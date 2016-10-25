/*
 * baffles_velocity.java
 */

import com.comsol.model.*;
import com.comsol.model.util.*;

/** Model exported on Oct 25 2016, 10:58 by COMSOL 5.2.1.199. */
public class baffles_velocity {

  public static Model run(String wdir, String rect1W, String rect1H, String rect2Y, String rect3Y, String rect4W, String rect4Y, String rect5W, String rect5Y, String rect6W, String rect6Y, String rect7W, String rect7Y, String rect8W, String rect8Y, String rect9W, String rect9Y) {

	
	Model model = ModelUtil.create("Model");

    model.modelPath(wdir);

    model.comments("Untitled\n\n");

    model.modelNode().create("comp1");

    model.geom().create("geom1", 2);

    model.mesh().create("mesh1", "geom1");

    model.physics().create("spf", "LaminarFlow", "geom1");
    model.physics()
         .create("tds", "DilutedSpecies", "geom1", new String[][]{{"c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8"}});

    model.study().create("std1");
    model.study("std1").create("time", "Transient");
    model.study("std1").feature("time").activate("spf", true);
    model.study("std1").feature("time").activate("tds", true);

    model.geom("geom1").run("");
    model.geom("geom1").feature().create("r1", "Rectangle");
    model.geom("geom1").feature("r1").set("type", "solid");
    model.geom("geom1").feature("r1").set("base", "corner");
    model.geom("geom1").feature("r1").set("pos", new String[]{"1.5", "0"});
    model.geom("geom1").feature("r1").set("size", new String[]{rect1W, rect1H});
    model.geom("geom1").run("r1");
    model.geom("geom1").run("r1");

    model.label("pilotreactor_vel_algae_axial flow baffles_2D alt_rerebuild.mph");
	
    float f_rect3Xpos = Float.parseFloat(rect1W);
	f_rect3Xpos = f_rect3Xpos + 1.5f;
	String rect3X = Float.toString(f_rect3Xpos);
	
    model.geom("geom1").run("r1");
    model.geom("geom1").run("r1");
    model.geom("geom1").feature().create("r2", "Rectangle");
    model.geom("geom1").feature("r2").set("type", "solid");
    model.geom("geom1").feature("r2").set("base", "corner");
    model.geom("geom1").feature("r2").set("pos", new String[]{"0", rect2Y});
    model.geom("geom1").feature("r2").set("size", new String[]{"1.5", "0.12"});
    model.geom("geom1").run("r2");
    model.geom("geom1").run("r2");
    model.geom("geom1").feature().create("r3", "Rectangle");
    model.geom("geom1").feature("r3").set("type", "solid");
    model.geom("geom1").feature("r3").set("base", "corner");
    model.geom("geom1").feature("r3").set("pos", new String[]{rect3X, rect3Y});
    model.geom("geom1").feature("r3").set("size", new String[]{"1.5", "0.12"});
    model.geom("geom1").run("r3");
    model.geom("geom1").run("r3");
    model.geom("geom1").feature().create("r4", "Rectangle");
    model.geom("geom1").feature("r4").set("type", "solid");
    model.geom("geom1").feature("r4").set("base", "corner");
    model.geom("geom1").feature("r4").set("pos", new String[]{"1.46", "1.48"});
    model.geom("geom1").feature("r4").set("size", new String[]{"0.04", "0.02"});
    model.geom("geom1").run("r4");
    model.geom("geom1").feature().remove("r4");
    model.geom("geom1").run("r3");
    model.geom("geom1").run("r3");
    model.geom("geom1").feature().create("r4", "Rectangle");
    model.geom("geom1").feature("r4").set("type", "solid");
    model.geom("geom1").feature("r4").set("base", "corner");
    model.geom("geom1").feature("r4").set("pos", new String[]{"1.5", rect4Y});
    model.geom("geom1").feature("r4").set("size", new String[]{rect4W, "0.12"});
    model.geom("geom1").run("r4");
    model.geom("geom1").run("r4");
    model.geom("geom1").feature().create("r5", "Rectangle");
    model.geom("geom1").feature("r5").set("type", "solid");
    model.geom("geom1").feature("r5").set("base", "corner");
    model.geom("geom1").feature("r5").set("pos", new String[]{"1.5", rect5Y});
    model.geom("geom1").feature("r5").set("size", new String[]{rect5W, "0.12"});
    model.geom("geom1").run("r5");
    model.geom("geom1").run("r5");
    model.geom("geom1").feature().create("r6", "Rectangle");
    model.geom("geom1").feature("r6").set("type", "solid");
    model.geom("geom1").feature("r6").set("base", "corner");
    model.geom("geom1").feature("r6").set("pos", new String[]{"1.5", rect6Y});
    model.geom("geom1").feature("r6").set("size", new String[]{rect6W, "0.12"});
    model.geom("geom1").run("r6");
    model.geom("geom1").run("r6");
	
	float aux = Float.parseFloat(rect1W);
	float rect7X_p = aux - Float.parseFloat(rect7W) + 1.5f;
	float rect8X_p = aux - Float.parseFloat(rect8W) + 1.5f;
	float rect9X_p = aux - Float.parseFloat(rect9W) + 1.5f;
	
	String rect7X = Float.toString(rect7X_p);
	String rect8X = Float.toString(rect8X_p);
	String rect9X = Float.toString(rect9X_p);
	
	
    model.geom("geom1").feature().create("r7", "Rectangle");
    model.geom("geom1").feature("r7").set("type", "solid");
    model.geom("geom1").feature("r7").set("base", "corner");
    model.geom("geom1").feature("r7").set("pos", new String[]{rect7X, rect7Y});
    model.geom("geom1").feature("r7").set("size", new String[]{rect7W, "0.12"});
    model.geom("geom1").run("r7");
    model.geom("geom1").run("r7");
    model.geom("geom1").feature().create("r8", "Rectangle");
    model.geom("geom1").feature("r8").set("type", "solid");
    model.geom("geom1").feature("r8").set("base", "corner");
    model.geom("geom1").feature("r8").set("pos", new String[]{rect8X, rect8Y});
    model.geom("geom1").feature("r8").set("size", new String[]{rect8W, "0.12"});
    model.geom("geom1").run("r8");
    model.geom("geom1").run("r8");
    model.geom("geom1").feature().create("r9", "Rectangle");
    model.geom("geom1").feature("r9").set("type", "solid");
    model.geom("geom1").feature("r9").set("base", "corner");
    model.geom("geom1").feature("r9").set("pos", new String[]{rect9X, rect9Y});
    model.geom("geom1").feature("r9").set("size", new String[]{rect9W, "0.12"});
    model.geom("geom1").run("r9");

    model.selection().create("uni1", "Union");

    model.geom("geom1").run();

    model.selection("uni1").set("input", new String[]{});
    model.selection().create("dif1", "Difference");
    model.selection("dif1").set("add", new String[]{});

    model.physics("spf").create("wall2", "Wall", 1);
    model.physics("spf").feature("wall2").selection()
         .set(new int[]{2, 3, 4, 5, 7, 8, 10, 12, 14, 16, 18, 20, 33, 34, 35, 36, 37, 38, 39, 41, 42, 43});
    model.physics("spf").create("inl1", "InletBoundary", 1);
    model.physics("spf").feature("inl1").selection().set(new int[]{1});
    model.physics("spf").create("out1", "OutletBoundary", 1);
    model.physics("spf").feature("out1").selection().set(new int[]{44});

    model.material().create("mat1", "Common", "comp1");
    model.material("mat1").label("Water");
    model.material("mat1").set("family", "water");
    model.material("mat1").propertyGroup("def").set("dynamicviscosity", "eta(T[1/K])[Pa*s]");
    model.material("mat1").propertyGroup("def").set("ratioofspecificheat", "1.0");
    model.material("mat1").propertyGroup("def").set("electricconductivity", "5.5e-6[S/m]");
    model.material("mat1").propertyGroup("def").set("heatcapacity", "Cp(T[1/K])[J/(kg*K)]");
    model.material("mat1").propertyGroup("def").set("density", "rho(T[1/K])[kg/m^3]");
    model.material("mat1").propertyGroup("def").set("thermalconductivity", "k(T[1/K])[W/(m*K)]");
    model.material("mat1").propertyGroup("def").set("soundspeed", "cs(T[1/K])[m/s]");
    model.material("mat1").propertyGroup("def").func().create("eta", "Piecewise");
    model.material("mat1").propertyGroup("def").func("eta").set("funcname", "eta");
    model.material("mat1").propertyGroup("def").func("eta").set("arg", "T");
    model.material("mat1").propertyGroup("def").func("eta").set("extrap", "constant");
    model.material("mat1").propertyGroup("def").func("eta")
         .set("pieces", new String[][]{{"273.15", "413.15", "1.3799566804-0.021224019151*T^1+1.3604562827E-4*T^2-4.6454090319E-7*T^3+8.9042735735E-10*T^4-9.0790692686E-13*T^5+3.8457331488E-16*T^6"}, {"413.15", "553.75", "0.00401235783-2.10746715E-5*T^1+3.85772275E-8*T^2-2.39730284E-11*T^3"}});
    model.material("mat1").propertyGroup("def").func().create("Cp", "Piecewise");
    model.material("mat1").propertyGroup("def").func("Cp").set("funcname", "Cp");
    model.material("mat1").propertyGroup("def").func("Cp").set("arg", "T");
    model.material("mat1").propertyGroup("def").func("Cp").set("extrap", "constant");
    model.material("mat1").propertyGroup("def").func("Cp")
         .set("pieces", new String[][]{{"273.15", "553.75", "12010.1471-80.4072879*T^1+0.309866854*T^2-5.38186884E-4*T^3+3.62536437E-7*T^4"}});
    model.material("mat1").propertyGroup("def").func().create("rho", "Piecewise");
    model.material("mat1").propertyGroup("def").func("rho").set("funcname", "rho");
    model.material("mat1").propertyGroup("def").func("rho").set("arg", "T");
    model.material("mat1").propertyGroup("def").func("rho").set("extrap", "constant");
    model.material("mat1").propertyGroup("def").func("rho")
         .set("pieces", new String[][]{{"273.15", "553.75", "838.466135+1.40050603*T^1-0.0030112376*T^2+3.71822313E-7*T^3"}});
    model.material("mat1").propertyGroup("def").func().create("k", "Piecewise");
    model.material("mat1").propertyGroup("def").func("k").set("funcname", "k");
    model.material("mat1").propertyGroup("def").func("k").set("arg", "T");
    model.material("mat1").propertyGroup("def").func("k").set("extrap", "constant");
    model.material("mat1").propertyGroup("def").func("k")
         .set("pieces", new String[][]{{"273.15", "553.75", "-0.869083936+0.00894880345*T^1-1.58366345E-5*T^2+7.97543259E-9*T^3"}});
    model.material("mat1").propertyGroup("def").func().create("cs", "Interpolation");
    model.material("mat1").propertyGroup("def").func("cs").set("sourcetype", "user");
    model.material("mat1").propertyGroup("def").func("cs").set("source", "table");
    model.material("mat1").propertyGroup("def").func("cs").set("funcname", "cs");
    model.material("mat1").propertyGroup("def").func("cs")
         .set("table", new String[][]{{"273", "1403"}, 
         {"278", "1427"}, 
         {"283", "1447"}, 
         {"293", "1481"}, 
         {"303", "1507"}, 
         {"313", "1526"}, 
         {"323", "1541"}, 
         {"333", "1552"}, 
         {"343", "1555"}, 
         {"353", "1555"}, 
         {"363", "1550"}, 
         {"373", "1543"}});
    model.material("mat1").propertyGroup("def").func("cs").set("interp", "piecewisecubic");
    model.material("mat1").propertyGroup("def").func("cs").set("extrap", "const");
    model.material("mat1").propertyGroup("def").addInput("temperature");
    model.material("mat1").set("family", "water");
    model.material().create("mat2", "Common", "comp1");
    model.material("mat2").label("Water 1");
    model.material("mat2").set("family", "water");
    model.material("mat2").propertyGroup("def").set("dynamicviscosity", "eta(T[1/K])[Pa*s]");
    model.material("mat2").propertyGroup("def").set("ratioofspecificheat", "1.0");
    model.material("mat2").propertyGroup("def").set("electricconductivity", "5.5e-6[S/m]");
    model.material("mat2").propertyGroup("def").set("heatcapacity", "Cp(T[1/K])[J/(kg*K)]");
    model.material("mat2").propertyGroup("def").set("density", "rho(T[1/K])[kg/m^3]");
    model.material("mat2").propertyGroup("def").set("thermalconductivity", "k(T[1/K])[W/(m*K)]");
    model.material("mat2").propertyGroup("def").set("soundspeed", "cs(T[1/K])[m/s]");
    model.material("mat2").propertyGroup("def").func().create("eta", "Piecewise");
    model.material("mat2").propertyGroup("def").func("eta").set("funcname", "eta");
    model.material("mat2").propertyGroup("def").func("eta").set("arg", "T");
    model.material("mat2").propertyGroup("def").func("eta").set("extrap", "constant");
    model.material("mat2").propertyGroup("def").func("eta")
         .set("pieces", new String[][]{{"273.15", "413.15", "1.3799566804-0.021224019151*T^1+1.3604562827E-4*T^2-4.6454090319E-7*T^3+8.9042735735E-10*T^4-9.0790692686E-13*T^5+3.8457331488E-16*T^6"}, {"413.15", "553.75", "0.00401235783-2.10746715E-5*T^1+3.85772275E-8*T^2-2.39730284E-11*T^3"}});
    model.material("mat2").propertyGroup("def").func().create("Cp", "Piecewise");
    model.material("mat2").propertyGroup("def").func("Cp").set("funcname", "Cp");
    model.material("mat2").propertyGroup("def").func("Cp").set("arg", "T");
    model.material("mat2").propertyGroup("def").func("Cp").set("extrap", "constant");
    model.material("mat2").propertyGroup("def").func("Cp")
         .set("pieces", new String[][]{{"273.15", "553.75", "12010.1471-80.4072879*T^1+0.309866854*T^2-5.38186884E-4*T^3+3.62536437E-7*T^4"}});
    model.material("mat2").propertyGroup("def").func().create("rho", "Piecewise");
    model.material("mat2").propertyGroup("def").func("rho").set("funcname", "rho");
    model.material("mat2").propertyGroup("def").func("rho").set("arg", "T");
    model.material("mat2").propertyGroup("def").func("rho").set("extrap", "constant");
    model.material("mat2").propertyGroup("def").func("rho")
         .set("pieces", new String[][]{{"273.15", "553.75", "838.466135+1.40050603*T^1-0.0030112376*T^2+3.71822313E-7*T^3"}});
    model.material("mat2").propertyGroup("def").func().create("k", "Piecewise");
    model.material("mat2").propertyGroup("def").func("k").set("funcname", "k");
    model.material("mat2").propertyGroup("def").func("k").set("arg", "T");
    model.material("mat2").propertyGroup("def").func("k").set("extrap", "constant");
    model.material("mat2").propertyGroup("def").func("k")
         .set("pieces", new String[][]{{"273.15", "553.75", "-0.869083936+0.00894880345*T^1-1.58366345E-5*T^2+7.97543259E-9*T^3"}});
    model.material("mat2").propertyGroup("def").func().create("cs", "Interpolation");
    model.material("mat2").propertyGroup("def").func("cs").set("sourcetype", "user");
    model.material("mat2").propertyGroup("def").func("cs").set("source", "table");
    model.material("mat2").propertyGroup("def").func("cs").set("funcname", "cs");
    model.material("mat2").propertyGroup("def").func("cs")
         .set("table", new String[][]{{"273", "1403"}, 
         {"278", "1427"}, 
         {"283", "1447"}, 
         {"293", "1481"}, 
         {"303", "1507"}, 
         {"313", "1526"}, 
         {"323", "1541"}, 
         {"333", "1552"}, 
         {"343", "1555"}, 
         {"353", "1555"}, 
         {"363", "1550"}, 
         {"373", "1543"}});
    model.material("mat2").propertyGroup("def").func("cs").set("interp", "piecewisecubic");
    model.material("mat2").propertyGroup("def").func("cs").set("extrap", "const");
    model.material("mat2").propertyGroup("def").addInput("temperature");
    model.material("mat2").set("family", "water");
    model.material().remove("mat2");

    model.study().create("std2");
    model.study("std2").create("stat", "Stationary");
    model.study("std2").feature("stat").activate("spf", true);
    model.study("std2").feature("stat").activate("tds", false);

    model.mesh("mesh1").autoMeshSize(4);
    model.mesh("mesh1").run();

    model.selection().create("dif2", "Difference");
    model.selection().remove("dif2");
    model.selection("dif1").set("add", new String[]{"uni1"});
    model.selection().create("uni2", "Union");
    model.selection("uni2").set("input", new String[]{"dif1"});
    model.selection().remove("uni2");
    model.selection("uni1").set("input", new String[]{});
    model.selection().remove("uni1");
    model.selection().remove("dif1");
    model.selection().create("uni1", "Union");
    model.selection().remove("uni1");

    model.geom("geom1").run("fin");
    model.geom("geom1").runPre("fin");
    model.geom("geom1").run("fin");

    model.selection().create("uni1", "Union");
    model.selection("uni1").set("entitydim", "2");
    model.selection().create("uni2", "Union");
    model.selection().create("uni3", "Union");
    model.selection().remove("uni3");
    model.selection().remove("uni2");
    model.selection("uni1").set("input", new String[]{});
    model.selection().create("uni2", "Union");
    model.selection().remove("uni2");
    model.selection().remove("uni1");
    model.selection().create("dif1", "Difference");
    model.selection().create("sel1", "Explicit");
    model.selection("sel1").set(new int[]{1, 2, 9});
    model.selection().create("uni1", "Union");
    model.selection("uni1").set("input", new String[]{"sel1"});
    model.selection().remove("dif1");
    model.selection().create("sel2", "Explicit");
    model.selection("sel2").set(new int[]{3, 4, 5, 6, 7, 8});
    model.selection().create("dif1", "Difference");
    model.selection("dif1").set("add", new String[]{"uni1"});
    model.selection("dif1").set("subtract", new String[]{"sel2"});

    model.mesh().remove("mesh1");
    model.mesh().create("mesh1", "geom1");
    model.mesh("mesh1").autoMeshSize(4);
    model.mesh("mesh1").run();
    model.mesh().remove("mesh1");

    model.selection().move("dif1", 2);
    model.selection().move("dif1", 1);
    model.selection().move("dif1", 0);

    model.geom("geom1").run("fin");

    model.selection().move("uni1", 1);

    model.mesh().create("mesh1", "geom1");

    model.label("pilotreactor_vel_algae_axial flow baffles_2D alt_rerebuild.mph");

    model.geom("geom1").run("r9");
    model.geom("geom1").create("uni1", "Union");
    model.geom("geom1").feature().remove("uni1");
    model.geom("geom1").run("r9");
    model.geom("geom1").create("uni1", "Union");
    model.geom("geom1").feature("uni1").selection("input").init();
    model.geom("geom1").feature("uni1").selection("input").set(new String[]{"r1", "r2", "r3"});
    model.geom("geom1").run("uni1");
    model.geom("geom1").run("uni1");
    model.geom("geom1").run("uni1");
    model.geom("geom1").run("uni1");
    model.geom("geom1").create("uni2", "Union");
    model.geom("geom1").feature("uni2").selection("input").init();
    model.geom("geom1").feature("uni2").selection("input").set(new String[]{"r4", "r5", "r8", "r7", "r6", "r9"});
    model.geom("geom1").run("uni2");
    model.geom("geom1").run("uni2");
    model.geom("geom1").create("dif1", "Difference");
    model.geom("geom1").feature("dif1").selection("input").add(new String[]{"uni1"});
    model.geom("geom1").feature("dif1").selection("input2").add(new String[]{"uni2"});
    model.geom("geom1").runPre("fin");
    model.geom("geom1").run();

    model.label("pilotreactor_vel_algae_axial flow baffles_2D alt_geometryonly.mph");

    model.sol().create("sol1");
    model.sol("sol1").study("std2");

    model.study("std2").feature("stat").set("notlistsolnum", 1);
    model.study("std2").feature("stat").set("notsolnum", "1");
    model.study("std2").feature("stat").set("listsolnum", 1);
    model.study("std2").feature("stat").set("solnum", "1");

    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std2");
    model.sol("sol1").feature("st1").set("studystep", "stat");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "stat");
    model.sol("sol1").create("s1", "Stationary");
    model.sol("sol1").feature("s1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("s1").feature("fc1").set("initstep", 0.01);
    model.sol("sol1").feature("s1").feature("fc1").set("minstep", 1.0E-6);
    model.sol("sol1").feature("s1").feature("fc1").set("dtech", "auto");
    model.sol("sol1").feature("s1").feature("fc1").set("maxiter", 100);
    model.sol("sol1").feature("s1").create("d1", "Direct");
    model.sol("sol1").feature("s1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("s1").feature("fc1").set("linsolver", "d1");
    model.sol("sol1").feature("s1").feature("fc1").set("initstep", 0.01);
    model.sol("sol1").feature("s1").feature("fc1").set("minstep", 1.0E-6);
    model.sol("sol1").feature("s1").feature("fc1").set("dtech", "auto");
    model.sol("sol1").feature("s1").feature("fc1").set("maxiter", 100);
    model.sol("sol1").feature("s1").feature().remove("fcDef");
    model.sol("sol1").attach("std2");

    model.result().create("pg1", "PlotGroup2D");
    model.result("pg1").label("Velocity (spf)");
    model.result("pg1").set("oldanalysistype", "noneavailable");
    model.result("pg1").set("frametype", "spatial");
    model.result("pg1").set("data", "dset1");
    model.result("pg1").feature().create("surf1", "Surface");
    model.result("pg1").feature("surf1").label("Surface");
    model.result("pg1").feature("surf1").set("oldanalysistype", "noneavailable");
    model.result("pg1").feature("surf1").set("differential", true);
    model.result("pg1").feature("surf1").set("data", "parent");
    model.result().create("pg2", "PlotGroup2D");
    model.result("pg2").label("Pressure (spf)");
    model.result("pg2").set("oldanalysistype", "noneavailable");
    model.result("pg2").set("frametype", "spatial");
    model.result("pg2").set("data", "dset1");
    model.result("pg2").feature().create("con1", "Contour");
    model.result("pg2").feature("con1").label("Contour");
    model.result("pg2").feature("con1").set("oldanalysistype", "noneavailable");
    model.result("pg2").feature("con1").set("expr", "p");
    model.result("pg2").feature("con1").set("differential", true);
    model.result("pg2").feature("con1").set("number", 40);
    model.result("pg2").feature("con1").set("data", "parent");

    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result("pg2").run();

    model.geom("geom1").feature("r3").set("pos", new String[]{"2.3", "4.5"});
    model.geom("geom1").run("r3");
    model.geom("geom1").feature("r3").set("pos", new String[]{rect3X, rect3Y});
    model.geom("geom1").run("r3");
    model.geom("geom1").runPre("fin");
    model.geom("geom1").run();

    model.param().set("uin", "1.447E-5 [m/s]");

    model.study("std1").feature("time").set("physselection", "spf");
    model.study("std1").feature("time").set("activate", new String[]{"spf", "on", "tds", "off"});

    model.physics("spf").feature("inl1").set("U0in", "uin");

    model.sol().create("sol2");
    model.sol("sol2").study("std1");

    model.study("std1").feature("time").set("notlistsolnum", 1);
    model.study("std1").feature("time").set("notsolnum", "1");
    model.study("std1").feature("time").set("listsolnum", 1);
    model.study("std1").feature("time").set("solnum", "1");

    model.sol("sol2").create("st1", "StudyStep");
    model.sol("sol2").feature("st1").set("study", "std1");
    model.sol("sol2").feature("st1").set("studystep", "time");
    model.sol("sol2").create("v1", "Variables");
    model.sol("sol2").feature("v1").set("control", "time");
    model.sol("sol2").create("t1", "Time");
    model.sol("sol2").feature("t1").set("tlist", "range(0,0.1,1)");
    model.sol("sol2").feature("t1").set("plot", "off");
    model.sol("sol2").feature("t1").set("plotgroup", "pg1");
    model.sol("sol2").feature("t1").set("plotfreq", "tout");
    model.sol("sol2").feature("t1").set("probesel", "all");
    model.sol("sol2").feature("t1").set("probes", new String[]{});
    model.sol("sol2").feature("t1").set("probefreq", "tsteps");
    model.sol("sol2").feature("t1").set("atolglobalmethod", "scaled");
    model.sol("sol2").feature("t1").set("atolglobal", 5.0E-4);
    model.sol("sol2").feature("t1").set("estrat", "exclude");
    model.sol("sol2").feature("t1").set("maxorder", 2);
    model.sol("sol2").feature("t1").set("control", "time");
    model.sol("sol2").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol2").feature("t1").feature("fc1").set("jtech", "once");
    model.sol("sol2").feature("t1").feature("fc1").set("maxiter", 6);
    model.sol("sol2").feature("t1").create("d1", "Direct");
    model.sol("sol2").feature("t1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol2").feature("t1").feature("fc1").set("linsolver", "d1");
    model.sol("sol2").feature("t1").feature("fc1").set("jtech", "once");
    model.sol("sol2").feature("t1").feature("fc1").set("maxiter", 6);
    model.sol("sol2").feature("t1").feature().remove("fcDef");
    model.sol("sol2").attach("std1");

    model.result().create("pg3", "PlotGroup2D");
    model.result("pg3").label("Velocity (spf) 1");
    model.result("pg3").set("data", "dset2");
    model.result("pg3").set("oldanalysistype", "noneavailable");
    model.result("pg3").set("frametype", "spatial");
    model.result("pg3").set("data", "dset2");
    model.result("pg3").feature().create("surf1", "Surface");
    model.result("pg3").feature("surf1").label("Surface");
    model.result("pg3").feature("surf1").set("oldanalysistype", "noneavailable");
    model.result("pg3").feature("surf1").set("differential", true);
    model.result("pg3").feature("surf1").set("data", "parent");
    model.result().create("pg4", "PlotGroup2D");
    model.result("pg4").label("Pressure (spf) 1");
    model.result("pg4").set("data", "dset2");
    model.result("pg4").set("oldanalysistype", "noneavailable");
    model.result("pg4").set("frametype", "spatial");
    model.result("pg4").set("data", "dset2");
    model.result("pg4").feature().create("con1", "Contour");
    model.result("pg4").feature("con1").label("Contour");
    model.result("pg4").feature("con1").set("oldanalysistype", "noneavailable");
    model.result("pg4").feature("con1").set("expr", "p");
    model.result("pg4").feature("con1").set("differential", true);
    model.result("pg4").feature("con1").set("number", 40);
    model.result("pg4").feature("con1").set("data", "parent");

    model.sol("sol2").runAll();

    model.result("pg3").run();
    model.result("pg3").run();
    model.result("pg3").set("allowtableupdate", false);
    model.result("pg3").set("allowevalintitle", false);
    model.result("pg3").set("title", "Time=1 s Surface: Velocity magnitude (m/s)");
    model.result("pg3").set("xlabel", "");
    model.result("pg3").set("ylabel", "");
    model.result("pg3").set("hasbeenplotted", true);
    model.result("pg3").feature("surf1").set("rangeunit", "m/s");
    model.result("pg3").feature("surf1").set("rangecolormin", 0);
    model.result("pg3").feature("surf1").set("rangecolormax", 2.0771894101524522E-5);
    model.result("pg3").feature("surf1").set("rangecoloractive", "off");
    model.result("pg3").feature("surf1").set("rangedatamin", 0);
    model.result("pg3").feature("surf1").set("rangedatamax", 2.0771894101524522E-5);
    model.result("pg3").feature("surf1").set("rangedataactive", "off");
    model.result("pg3").feature("surf1").set("rangeactualminmax", new double[]{0, 2.0771894101524522E-5});
    model.result("pg3").feature("surf1").set("hasbeenplotted", true);
    model.result("pg3").set("renderdatacached", false);
    model.result("pg3").set("allowtableupdate", true);
    model.result("pg3").set("renderdatacached", true);
    model.result().table().create("evl2", "Table");
    model.result().table("evl2").comments("Interactive 2D values");
    model.result().table("evl2").label("Evaluation 2D");
    model.result().table("evl2")
         .addRow(new double[]{2.014343500137329, 0.43442606925964355, 1.4124139227059045E-6}, new double[]{0, 0, 0});
    model.result("pg3").run();

    model.param().set("uin", "0.001 [m/s]");

    model.sol("sol2").study("std1");

    model.study("std1").feature("time").set("notlistsolnum", 1);
    model.study("std1").feature("time").set("notsolnum", "1");
    model.study("std1").feature("time").set("listsolnum", 1);
    model.study("std1").feature("time").set("solnum", "1");

    model.sol("sol2").feature().remove("t1");
    model.sol("sol2").feature().remove("v1");
    model.sol("sol2").feature().remove("st1");
    model.sol("sol2").create("st1", "StudyStep");
    model.sol("sol2").feature("st1").set("study", "std1");
    model.sol("sol2").feature("st1").set("studystep", "time");
    model.sol("sol2").create("v1", "Variables");
    model.sol("sol2").feature("v1").set("control", "time");
    model.sol("sol2").create("t1", "Time");
    model.sol("sol2").feature("t1").set("tlist", "range(0,0.1,1)");
    model.sol("sol2").feature("t1").set("plot", "off");
    model.sol("sol2").feature("t1").set("plotgroup", "pg1");
    model.sol("sol2").feature("t1").set("plotfreq", "tout");
    model.sol("sol2").feature("t1").set("probesel", "all");
    model.sol("sol2").feature("t1").set("probes", new String[]{});
    model.sol("sol2").feature("t1").set("probefreq", "tsteps");
    model.sol("sol2").feature("t1").set("atolglobalmethod", "scaled");
    model.sol("sol2").feature("t1").set("atolglobal", 5.0E-4);
    model.sol("sol2").feature("t1").set("estrat", "exclude");
    model.sol("sol2").feature("t1").set("maxorder", 2);
    model.sol("sol2").feature("t1").set("control", "time");
    model.sol("sol2").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol2").feature("t1").feature("fc1").set("jtech", "once");
    model.sol("sol2").feature("t1").feature("fc1").set("maxiter", 6);
    model.sol("sol2").feature("t1").create("d1", "Direct");
    model.sol("sol2").feature("t1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol2").feature("t1").feature("fc1").set("linsolver", "d1");
    model.sol("sol2").feature("t1").feature("fc1").set("jtech", "once");
    model.sol("sol2").feature("t1").feature("fc1").set("maxiter", 6);
    model.sol("sol2").feature("t1").feature().remove("fcDef");
    model.sol("sol2").attach("std1");
    model.sol("sol2").runAll();

    model.result("pg3").run();

    model.param().set("uin", "1.447E-5 [m/s]");

    model.mesh("mesh1").autoMeshSize(4);

    model.sol("sol2").study("std1");

    model.study("std1").feature("time").set("notlistsolnum", 1);
    model.study("std1").feature("time").set("notsolnum", "1");
    model.study("std1").feature("time").set("listsolnum", 1);
    model.study("std1").feature("time").set("solnum", "1");

    model.sol("sol2").feature().remove("t1");
    model.sol("sol2").feature().remove("v1");
    model.sol("sol2").feature().remove("st1");
    model.sol("sol2").create("st1", "StudyStep");
    model.sol("sol2").feature("st1").set("study", "std1");
    model.sol("sol2").feature("st1").set("studystep", "time");
    model.sol("sol2").create("v1", "Variables");
    model.sol("sol2").feature("v1").set("control", "time");
    model.sol("sol2").create("t1", "Time");
    model.sol("sol2").feature("t1").set("tlist", "range(0,0.1,1)");
    model.sol("sol2").feature("t1").set("plot", "off");
    model.sol("sol2").feature("t1").set("plotgroup", "pg1");
    model.sol("sol2").feature("t1").set("plotfreq", "tout");
    model.sol("sol2").feature("t1").set("probesel", "all");
    model.sol("sol2").feature("t1").set("probes", new String[]{});
    model.sol("sol2").feature("t1").set("probefreq", "tsteps");
    model.sol("sol2").feature("t1").set("atolglobalmethod", "scaled");
    model.sol("sol2").feature("t1").set("atolglobal", 5.0E-4);
    model.sol("sol2").feature("t1").set("estrat", "exclude");
    model.sol("sol2").feature("t1").set("maxorder", 2);
    model.sol("sol2").feature("t1").set("control", "time");
    model.sol("sol2").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol2").feature("t1").feature("fc1").set("jtech", "once");
    model.sol("sol2").feature("t1").feature("fc1").set("maxiter", 6);
    model.sol("sol2").feature("t1").create("d1", "Direct");
    model.sol("sol2").feature("t1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol2").feature("t1").feature("fc1").set("linsolver", "d1");
    model.sol("sol2").feature("t1").feature("fc1").set("jtech", "once");
    model.sol("sol2").feature("t1").feature("fc1").set("maxiter", 6);
    model.sol("sol2").feature("t1").feature().remove("fcDef");
    model.sol("sol2").attach("std1");
    model.sol("sol2").runAll();

    model.result("pg3").run();

    model.study("std1").feature("time").set("tlist", "range(0,60*5,60*60*24)");

    model.sol("sol2").study("std1");

    model.study("std1").feature("time").set("notlistsolnum", 1);
    model.study("std1").feature("time").set("notsolnum", "1");
    model.study("std1").feature("time").set("listsolnum", 1);
    model.study("std1").feature("time").set("solnum", "1");

    model.sol("sol2").feature().remove("t1");
    model.sol("sol2").feature().remove("v1");
    model.sol("sol2").feature().remove("st1");
    model.sol("sol2").create("st1", "StudyStep");
    model.sol("sol2").feature("st1").set("study", "std1");
    model.sol("sol2").feature("st1").set("studystep", "time");
    model.sol("sol2").create("v1", "Variables");

    return model;
  }

  public static Model run2(Model model, String wdir) {
    model.sol("sol2").feature("v1").set("control", "time");
    model.sol("sol2").create("t1", "Time");
    model.sol("sol2").feature("t1").set("tlist", "range(0,60*5,60*60*24)");
    model.sol("sol2").feature("t1").set("plot", "off");
    model.sol("sol2").feature("t1").set("plotgroup", "pg1");
    model.sol("sol2").feature("t1").set("plotfreq", "tout");
    model.sol("sol2").feature("t1").set("probesel", "all");
    model.sol("sol2").feature("t1").set("probes", new String[]{});
    model.sol("sol2").feature("t1").set("probefreq", "tsteps");
    model.sol("sol2").feature("t1").set("atolglobalmethod", "scaled");
    model.sol("sol2").feature("t1").set("atolglobal", 5.0E-4);
    model.sol("sol2").feature("t1").set("estrat", "exclude");
    model.sol("sol2").feature("t1").set("maxorder", 2);
    model.sol("sol2").feature("t1").set("control", "time");
    model.sol("sol2").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol2").feature("t1").feature("fc1").set("jtech", "once");
    model.sol("sol2").feature("t1").feature("fc1").set("maxiter", 6);
    model.sol("sol2").feature("t1").create("d1", "Direct");
    model.sol("sol2").feature("t1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol2").feature("t1").feature("fc1").set("linsolver", "d1");
    model.sol("sol2").feature("t1").feature("fc1").set("jtech", "once");
    model.sol("sol2").feature("t1").feature("fc1").set("maxiter", 6);
    model.sol("sol2").feature("t1").feature().remove("fcDef");
    model.sol("sol2").attach("std1");
    model.sol("sol2").runAll();

    model.result("pg3").run();
    model.result("pg3").run();

    model.physics("tds").prop("TransportMechanism").set("Convection", true);

    model.sol("sol1").study("std2");

    model.study("std2").feature("stat").set("notlistsolnum", 1);
    model.study("std2").feature("stat").set("notsolnum", "1");
    model.study("std2").feature("stat").set("listsolnum", 1);
    model.study("std2").feature("stat").set("solnum", "1");

    model.sol("sol1").feature().remove("s1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std2");
    model.sol("sol1").feature("st1").set("studystep", "stat");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "stat");
    model.sol("sol1").create("s1", "Stationary");
    model.sol("sol1").feature("s1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("s1").feature("fc1").set("initstep", 0.01);
    model.sol("sol1").feature("s1").feature("fc1").set("minstep", 1.0E-6);
    model.sol("sol1").feature("s1").feature("fc1").set("dtech", "auto");
    model.sol("sol1").feature("s1").feature("fc1").set("maxiter", 100);
    model.sol("sol1").feature("s1").create("d1", "Direct");
    model.sol("sol1").feature("s1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("s1").feature("fc1").set("linsolver", "d1");
    model.sol("sol1").feature("s1").feature("fc1").set("initstep", 0.01);
    model.sol("sol1").feature("s1").feature("fc1").set("minstep", 1.0E-6);
    model.sol("sol1").feature("s1").feature("fc1").set("dtech", "auto");
    model.sol("sol1").feature("s1").feature("fc1").set("maxiter", 100);
    model.sol("sol1").feature("s1").feature().remove("fcDef");
    model.sol("sol1").attach("std2");
    model.sol("sol1").runAll();

    model.result("pg1").run();

    model.study().remove("std1");

    /*model.geom("geom1").feature("r7").set("pos", new String[]{"1.9", "1.5"});
    model.geom("geom1").run("r7");
    model.geom("geom1").feature("r7").set("pos", new String[]{"1.83", "1.5"});
    model.geom("geom1").run("r7");
    model.geom("geom1").feature("r7").set("pos", new String[]{"1.83", "1.6"});
    model.geom("geom1").run("r7");
    model.geom("geom1").feature("r7").set("pos", new String[]{"1.83", "1.5"});
    model.geom("geom1").runPre("fin");
    model.geom("geom1").feature("r7").set("rot", "20");
    model.geom("geom1").run("r7");*/

    model.sol("sol1").study("std2");

    model.study("std2").feature("stat").set("notlistsolnum", 1);
    model.study("std2").feature("stat").set("notsolnum", "1");
    model.study("std2").feature("stat").set("listsolnum", 1);
    model.study("std2").feature("stat").set("solnum", "1");

    model.sol("sol1").feature().remove("s1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std2");
    model.sol("sol1").feature("st1").set("studystep", "stat");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "stat");
    model.sol("sol1").create("s1", "Stationary");
    model.sol("sol1").feature("s1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("s1").feature("fc1").set("initstep", 0.01);
    model.sol("sol1").feature("s1").feature("fc1").set("minstep", 1.0E-6);
    model.sol("sol1").feature("s1").feature("fc1").set("dtech", "auto");
    model.sol("sol1").feature("s1").feature("fc1").set("maxiter", 100);
    model.sol("sol1").feature("s1").create("d1", "Direct");
    model.sol("sol1").feature("s1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("s1").feature("fc1").set("linsolver", "d1");
    model.sol("sol1").feature("s1").feature("fc1").set("initstep", 0.01);
    model.sol("sol1").feature("s1").feature("fc1").set("minstep", 1.0E-6);
    model.sol("sol1").feature("s1").feature("fc1").set("dtech", "auto");
    model.sol("sol1").feature("s1").feature("fc1").set("maxiter", 100);
    model.sol("sol1").feature("s1").feature().remove("fcDef");
    model.sol("sol1").attach("std2");
    model.sol("sol1").runAll();

    model.result("pg1").run();

    /*model.geom("geom1").feature("r7").set("rot", "45");
    model.geom("geom1").run("r7");
    model.geom("geom1").feature("r7").set("rot", "90");
    model.geom("geom1").run("r7");
    model.geom("geom1").feature("r7").set("rot", "180");
    model.geom("geom1").run("r7");
    model.geom("geom1").feature("r7").set("rot", "0");
    model.geom("geom1").run("r7");
    model.geom("geom1").runPre("fin");
    model.geom("geom1").run();*/

    model.mesh("mesh1").run();
    model.mesh("mesh1").autoMeshSize(1);
    model.mesh("mesh1").run();

    model.sol("sol1").study("std2");

    model.study("std2").feature("stat").set("notlistsolnum", 1);
    model.study("std2").feature("stat").set("notsolnum", "1");
    model.study("std2").feature("stat").set("listsolnum", 1);
    model.study("std2").feature("stat").set("solnum", "1");

    model.sol("sol1").feature().remove("s1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std2");
    model.sol("sol1").feature("st1").set("studystep", "stat");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "stat");
    model.sol("sol1").create("s1", "Stationary");
    model.sol("sol1").feature("s1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("s1").feature("fc1").set("initstep", 0.01);
    model.sol("sol1").feature("s1").feature("fc1").set("minstep", 1.0E-6);
    model.sol("sol1").feature("s1").feature("fc1").set("dtech", "auto");
    model.sol("sol1").feature("s1").feature("fc1").set("maxiter", 100);
    model.sol("sol1").feature("s1").create("d1", "Direct");
    model.sol("sol1").feature("s1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("s1").feature("fc1").set("linsolver", "d1");
    model.sol("sol1").feature("s1").feature("fc1").set("initstep", 0.01);
    model.sol("sol1").feature("s1").feature("fc1").set("minstep", 1.0E-6);
    model.sol("sol1").feature("s1").feature("fc1").set("dtech", "auto");
    model.sol("sol1").feature("s1").feature("fc1").set("maxiter", 100);
    model.sol("sol1").feature("s1").feature().remove("fcDef");
    model.sol("sol1").attach("std2");
    model.sol("sol1").runAll();

    model.result("pg1").run();

    model.mesh("mesh1").autoMeshSize(9);
    model.mesh("mesh1").run();

    model.sol("sol1").study("std2");

    model.study("std2").feature("stat").set("notlistsolnum", 1);
    model.study("std2").feature("stat").set("notsolnum", "1");
    model.study("std2").feature("stat").set("listsolnum", 1);
    model.study("std2").feature("stat").set("solnum", "1");

    model.sol("sol1").feature().remove("s1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std2");
    model.sol("sol1").feature("st1").set("studystep", "stat");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "stat");
    model.sol("sol1").create("s1", "Stationary");
    model.sol("sol1").feature("s1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("s1").feature("fc1").set("initstep", 0.01);
    model.sol("sol1").feature("s1").feature("fc1").set("minstep", 1.0E-6);
    model.sol("sol1").feature("s1").feature("fc1").set("dtech", "auto");
    model.sol("sol1").feature("s1").feature("fc1").set("maxiter", 100);
    model.sol("sol1").feature("s1").create("d1", "Direct");
    model.sol("sol1").feature("s1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("s1").feature("fc1").set("linsolver", "d1");
    model.sol("sol1").feature("s1").feature("fc1").set("initstep", 0.01);
    model.sol("sol1").feature("s1").feature("fc1").set("minstep", 1.0E-6);
    model.sol("sol1").feature("s1").feature("fc1").set("dtech", "auto");
    model.sol("sol1").feature("s1").feature("fc1").set("maxiter", 100);
    model.sol("sol1").feature("s1").feature().remove("fcDef");
    model.sol("sol1").attach("std2");
    model.sol("sol1").runAll();

    model.result("pg1").run();

    model.mesh("mesh1").autoMeshSize(3);
    model.mesh("mesh1").autoMeshSize(4);
    model.mesh("mesh1").run();

    model.result("pg1").run();

    model.sol("sol1").study("std2");

    model.study("std2").feature("stat").set("notlistsolnum", 1);
    model.study("std2").feature("stat").set("notsolnum", "1");
    model.study("std2").feature("stat").set("listsolnum", 1);
    model.study("std2").feature("stat").set("solnum", "1");

    model.sol("sol1").feature().remove("s1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std2");
    model.sol("sol1").feature("st1").set("studystep", "stat");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "stat");
    model.sol("sol1").create("s1", "Stationary");
    model.sol("sol1").feature("s1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("s1").feature("fc1").set("initstep", 0.01);
    model.sol("sol1").feature("s1").feature("fc1").set("minstep", 1.0E-6);
    model.sol("sol1").feature("s1").feature("fc1").set("dtech", "auto");
    model.sol("sol1").feature("s1").feature("fc1").set("maxiter", 100);
    model.sol("sol1").feature("s1").create("d1", "Direct");
    model.sol("sol1").feature("s1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("s1").feature("fc1").set("linsolver", "d1");
    model.sol("sol1").feature("s1").feature("fc1").set("initstep", 0.01);
    model.sol("sol1").feature("s1").feature("fc1").set("minstep", 1.0E-6);
    model.sol("sol1").feature("s1").feature("fc1").set("dtech", "auto");
    model.sol("sol1").feature("s1").feature("fc1").set("maxiter", 100);
    model.sol("sol1").feature("s1").feature().remove("fcDef");
    model.sol("sol1").attach("std2");
    model.sol("sol1").runAll();

    model.result("pg1").run();

    model.label("pilotreactor_vel_algae_axial flow baffles_2D alt_velocity.mph");

    model.result("pg1").run();
    model.result().export().create("data1", "Data");
    model.result().export("data1").set("expr", new String[]{"u"});
    model.result().export("data1").set("descr", new String[]{"Velocity field, x component"});
    model.result().export("data1")
         .set("filename", wdir + "\\Velocity.txt");
    model.result().export("data1").run();

    return model;
  }

  public static void main(String[] args) {
    Model model = run(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11], args[12], args[13], args[14], args[15], args[16]);
    run2(model, args[0]);
  }

}
