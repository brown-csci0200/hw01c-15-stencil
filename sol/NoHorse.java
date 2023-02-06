package sol;

import src.IHorseTree;

public class NoHorse {
    public NoHorse(){}

    @Override
    public String toString() {
        return this.stringHelper(0);
    }

    public String stringHelper(int indent) {
        return indent + "none";
    }

    public String nameString() {return "none"; }

    @Override
    public IHorseTree addAncestors(String horseName, String momName,
                                   String momColor, String dadName, String dadColor) {
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof NoHorse;
    }
}
