package src;

public interface IHorseTree {
    public IHorseTree addAncestors(String horseName, String momName,
                                   String momColor, String dadName, String dadColor);
    public String nameString();
    String stringHelper(int indent);
}
