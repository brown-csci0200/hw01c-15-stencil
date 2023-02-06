package src;

/**
 * Interface for IHorseTree objects
 */
public interface IHorseTree {
    /**
     * Add a horse's ancestors to the tree.
     * @param horseName
     * @param momName
     * @param momColor
     * @param dadName
     * @param dadColor
     * @return an IHorseTree of all the horse and its parents added to the tree
     */
    public IHorseTree addAncestors(String horseName, String momName,
                                   String momColor, String dadName, String dadColor);

    /**
     * @return The horse's name
     */
    public String nameString();

    /**
     * Helper method for making stings representing trees
     * @param indent
     * @return String representation for this node
     */
    String stringHelper(int indent);
}
