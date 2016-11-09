/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMSOLmaster;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jenetics.DoubleGene;
import org.jenetics.MeanAlterer;
import org.jenetics.Mutator;
import org.jenetics.Optimize;
import org.jenetics.Phenotype;
import org.jenetics.engine.Engine;
import org.jenetics.engine.EvolutionResult; 
import static org.jenetics.engine.EvolutionResult.toBestPhenotype;
import org.jenetics.engine.EvolutionStatistics;
import org.jenetics.engine.codecs;
import static org.jenetics.engine.limit.bySteadyFitness;
import org.jenetics.util.DoubleRange;


/**
 *
 * @author Pedro Anchieta
 */
public class Optimizer {
        
        private static String classfile;
        private static final double BAFFLE_W_MIN = 0.2;
        private static final double BAFFLE_W_MAX = 0.66; 
        private static final double RECT2_Y_MIN = 0;
        private static final double RECT2_Y_MAX = 0.1; /*Limiting inlet to a height 0-10%*/
        private static final double RECT1_SIZE_Y_MIN = 0.5;
        private static final double RECT1_SIZE_Y_MAX = 10;
        private static final double RECT3_Y_MIN = 0.9; /*Limiting outlet to a height of 90-100%*/
        private static final double RECT3_Y_MAX = 1;

                
 
        
        private final double mutationProb; //0.03
        private final double xOver; //0.6
        private final double offspringFraction;
        private final int nThreads;
        private final int maxGens;
        private final int popSize;
                
    public Optimizer ()
    {
        mutationProb = 0.1;
        xOver = 0.05;
        nThreads = 1;
        maxGens = 100;
        popSize = 30;
        offspringFraction = 0.5;
        
    }

    private static double fitness(final double[] x) { /*NOT thread safe. Yet...*/
	
    try {
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd " + System.getProperty("user.dir"));
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            
            File fout = new File("log.txt");
            FileOutputStream fos = new FileOutputStream(fout);
                                
            while (true)
            {
                line = r.readLine();
                if (line == null) { break; }
                System.out.println(line);
            }
                       
            
            double rect1X, rect2Ypos, rect3Ypos, baffle_H;
            
            rect2Ypos = rect3Ypos = x[0] - 0.12;
            rect2Ypos = rect2Ypos * x[1];
            rect3Ypos = rect3Ypos * x[2];
            rect1X = 5/x[0];
            baffle_H = 0.079/(x[3]*rect1X);
                    
                        
            builder.command("cmd.exe", "/c", "comsolbatch -inputfile " + classfile + " \"%cd%\" " + rect1X + " " + x[0] + " " + rect2Ypos + " " + rect3Ypos
                    + " " + x[3]*rect1X + " " + baffle_H); 
                    
            p = builder.start();
            r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            try (BufferedWriter lg = new BufferedWriter(new OutputStreamWriter(fos)))
              {
                  while (true)
                    {
                        line = r.readLine();
                        if (line == null) { break; }
                        System.out.println(line);
                        lg.write(line);
                        lg.newLine();
                    }
                  lg.close();
              }
            catch(IOException e)
            {
                System.err.println("IOException: " + e.getMessage());
            }
            
            LogHandler lh = new LogHandler ("log.txt");
            
            if (lh.error()) //Handle error that was detected
            {
                System.out.println ("Error detected in COMSOL log file");
                 
            }                
              
 
            OutputReader or = new OutputReader("Mass.txt");
            try(FileWriter fw = new FileWriter("All Fitnesses.txt", true);
                    
            BufferedWriter bw = new BufferedWriter(fw);
                    
            PrintWriter out = new PrintWriter(bw))
            {
                /*Printing each fitness function to file conv.txt*/
                    out.println(rect1X + " " + x[0] + " " + rect2Ypos + " " + rect3Ypos
            + " " + x[3]*rect1X+ " " + baffle_H + " ->" + or.avgMass());
                
            
            } 
            catch (IOException e) 
            {
                System.err.println("Error: " + e.getMessage());
            }
            
                              
            return or.avgMass();
        } 
    catch (IOException ex) 
        {
            Logger.getLogger(Optimizer.class.getName()).log(Level.SEVERE, null, ex);
        }
    return 0;
}
    
    public void genetic(ExternalPrograms ep) throws IOException
    {
        ep.init();
        Optimizer.classfile = ep.getClassfile();

       
        final ExecutorService executor = Executors.newFixedThreadPool(nThreads);
        final Engine<DoubleGene, Double> engine = Engine
			.builder(
				Optimizer::fitness,
				codecs.ofVector(DoubleRange.of(RECT1_SIZE_Y_MIN,RECT1_SIZE_Y_MAX),
                                        DoubleRange.of(RECT2_Y_MIN,RECT2_Y_MAX),
                                        DoubleRange.of(RECT3_Y_MIN,RECT3_Y_MAX),
                                        DoubleRange.of(BAFFLE_W_MIN,BAFFLE_W_MAX)                                        
                                        )
                        )
                        .populationSize(popSize)
                        .offspringFraction(offspringFraction)
                        .optimize(Optimize.MAXIMUM)
			.alterers(
				new Mutator<>(mutationProb),
				new MeanAlterer<>(xOver))
                        .executor(executor)
                        .build();

		final EvolutionStatistics<Double, ?>
			statistics = EvolutionStatistics.ofNumber();
                

		/*final Phenotype<DoubleGene, Double> best = engine.stream()
			.limit(bySteadyFitness(3))
			.peek(statistics)
			.collect(toBestPhenotype());*/
                
            try(FileWriter fw = new FileWriter("Best.txt", true);       
            BufferedWriter bw = new BufferedWriter(fw);      
            PrintWriter out = new PrintWriter(bw))
            {
                final EvolutionResult<DoubleGene, Double> best = engine.stream() 
                        .limit(bySteadyFitness (7))
                        .limit(maxGens)
                        .peek(statistics)
                        .peek((EvolutionResult<DoubleGene, Double> best1) -> {
                            out.println(best1.getBestPhenotype()); /*Printing best from each generation*/
                })
                        .collect(EvolutionResult.toBestEvolutionResult()); /*Forcing elitism*/
                
                System.out.println(statistics);
                System.out.println("Best= " + best.getBestPhenotype());
                out.println(statistics);
                out.println(best.getBestPhenotype());
                
            }
                /*final EvolutionResult<DoubleGene, Double> best = engine.stream() 
                        .limit(maxGens)
                        .peek(statistics)
                        .collect(EvolutionResult.toBestEvolutionResult());*/


                
                /*System.out.println(engine.getSurvivorsSelector());*/
        
                

    }

 
}
