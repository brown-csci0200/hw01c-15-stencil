package sol;

import src.*;
import sol.HorseUtils;

/**
 * A class that tests whether your submission meets
 * the specifications of our autograder.
 */
public class AutograderCompatibility {


    /**
     * The main method of the autograder compatibility check.
     * @param args Unused
     *  TODO: Uncomment the body of the main method.
     *  (in IntelliJ, you can select all commented lines
     *  and press COMMAND+/ or CONTROL+/)
     *  TODO: Check that code compiles and runs.
     */
    public static void main(String[] args) {
        //-----------------------------
        // HorseUtils
        //-----------------------------
        HorseNode aA = new HorseNode(new Horse("", ""), new NoHorse(), new NoHorse());
        IHorseTree bHT = HorseUtils.buildHorseTree("", new FuncList<HorseData>());
        FuncList<HorseData> tL = new FuncList<HorseData>(
            new HorseData(new Horse("1","4"), "4", "2","3"),
            new HorseData(new Horse("3", "4"),"4", "4", "5"));
        String pO = HorseUtils.parentOf("1", tL, Parent.mother);
        HorseNode hT = new HorseNode(new Horse("1", "4"), new NoHorse(), new HorseNode(new Horse("2", "4"), new NoHorse(),
                new HorseNode(new Horse("3", "4"),new NoHorse(), new NoHorse())));
        System.out.println("Basic autograder compatibility passed");
    }
}
