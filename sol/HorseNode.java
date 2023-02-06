package sol;

import src.*;

public class HorseNode implements IHorseTree {
    private Horse horse;
    private IHorseTree momTree;
    private IHorseTree dadTree;

    public HorseNode(Horse h, IHorseTree m, IHorseTree d) {
        this.horse = h;
        this.momTree = m;
        this.dadTree = d;
    }

    @Override
    public IHorseTree addAncestors(String horseName, String momName,
                                       String momColor, String dadName, String dadColor) {
        return this;
    }

    public String nameString() {
        return this.horse.name();
    }

    @Override
    public String toString() {
        return this.stringHelper(0);
    }

    @Override
    public String stringHelper(int indent) {
        String builder = "HorseTree[\n";
        for (int i = 0; i < indent; i++) {
            builder += "    ";
        }
        builder += "    name=" + horse.name() + "\n";
        for (int i = 0; i < indent; i++) {
            builder += "    ";
        }
        if (momTree == null) {
            builder += "    momTree=null\n";
        } else {
            builder += "    momTree=" + momTree.stringHelper(indent + 1);
        }
        for (int i = 0; i < indent; i++) {
            builder += "    ";
        }
        if (dadTree == null) {
            builder += "    dadTree=null\n";
        } else {
            builder += "    dadTree=" + dadTree.stringHelper(indent + 1);
        }
        for (int i = 0; i < indent; i++) {
            builder += "    ";
        }
        builder += "]\n";
        return builder;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof HorseNode) {
            HorseNode other = (HorseNode) obj;
            return this.horse.equals(other.horse) &&
                    this.momTree.equals(other.momTree) &&
                    this.dadTree.equals(other.dadTree);
        } else return false;
    }
}