package sol;

import org.junit.Before;
import src.*;


public class Homework1CTest {
    // the horseAncestorList from the assignment handout
    private FuncList<HorseData> horseAncestorList;
    // TODO: create more data to test on

    @Before
    public void setUp() {
        horseAncestorList = new FuncList<HorseData>(
                new HorseData(new Horse("Cosquilla", "black"),"Black", "Quick Thought", "Papyrus"),
                new HorseData(new Horse("Miss Disco", "black"), "black","Outdone", "Discovery"),
                new HorseData(new Horse("Princequillo", "black"), "black","Cosquilla", "Prince Rose"),
                new HorseData(new Horse("Caruso", "black"), "black","Sweet Music", "Polymelian"),
                new HorseData(new Horse("Nasrullah", "black"), "black","Mumtaz Begum", "Nearco"),
                new HorseData(new Horse("Secretariat", "black"), "black","Somethingroyal", "Bold Ruler"),
                new HorseData(new Horse("Somethingroyal", "black"), "black","Imperatrice", "Princequillo"),
                new HorseData(new Horse("Bold Ruler", "black"), "black","Miss Disco", "Nasrullah"),
                new HorseData(new Horse("Prince Rose", "black"), "black","Indolence", "Rose Prince"),
                new HorseData(new Horse("Imperatrice", "black"), "black","Caruso", "Cinquepace"),
                new HorseData(new Horse("Nearco", "black"), "black","Nogara", "Pharos"));

        //TODO: initialize more data to test on
    }

    // TODO: write tests
}
