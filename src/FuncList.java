package src;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Implementation for a FuncList
 * @param <T>
 */
public class FuncList<T> implements IFuncList<T> {
    private T type; // used to check the type of list element in sum

    private LinkedList<T> theList;

    /**
     * Create a FuncList
     */
    public FuncList() {
        this.theList = new LinkedList<>();
    }

    private FuncList(LinkedList<T> initList) {
        this.theList = (LinkedList<T>)initList.clone();
    }

    /**
     * Create a FuncList
     * @param args Objects to add to the list
     */
    public FuncList(Object... args) {
        this.theList = new LinkedList<>();
        for (int i = 0; i <= args.length - 1; i++) {
            this.theList.add((T)args[i]);
        }
    }


    /**
     *
     * @param other
     * @return true if two FuncLists are equal
     */
    public boolean equals(Object other) {
        if (other instanceof FuncList) {
            return this.theList.equals(((FuncList<T>) other).theList);
        } else return false;
    }

    /**
     *
     * @return String representation of this list
     */
    public String toString() {
        return this.theList.toString();
    }

    /**
     *
     * @return true if the list has no elements
     */
    //*
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     *
     * @return the number of elements in the list
     */
    public int size() {
        return this.theList.size();
    }

    /**
     *
     * @param elem the element to add to the front of the list
     * @return a new list with elem followed by existing contents
     */
    public FuncList<T> link(T elem) {
        LinkedList<T> newList = (LinkedList<T>) this.theList.clone();
        newList.addFirst(elem);
        return new FuncList<T>(newList);
    }

    /**
     *
     * @return the first item in the list, throwing a
     * Runtime Exception if the list is empty
     */
    public T first() {
        if (this.theList.size() > 0)
            return this.theList.getFirst();
        else throw new RuntimeException("List is Empty");
    }

    /**
     *
     * @return the all but the first item in the list,
     * throwing a Runtime Exception if the list is empty
     */
    public FuncList<T> rest() {
        if (this.theList.size() > 0) {
            LinkedList<T> newList = (LinkedList<T>) this.theList.clone();
            newList.removeFirst();
            return new FuncList<T>(newList);
        }
        else throw new RuntimeException("List is Empty");
    }

    /**
     *
     * @param toFL the list whose items should append to this one
     * @return a new FuncList with the contents of this followed by otherFL
     */
    public FuncList<T> append(FuncList<T> toFL) {
        LinkedList<T> newList = (LinkedList<T>) this.theList.clone();
        newList.addAll(toFL.theList);
        return new FuncList<T>(newList);
    }

    /**
     *
     * @param pred a function from one element to boolean, indicating
     *            whether the element should appear in the output list
     * @return a list of all elements (in order) for which the given
     * function input returns true
     */
    // fix to preserve order
    public FuncList<T> filter(Function<T,Boolean> pred) {
        LinkedList<T> newList = new LinkedList<>();
        for (T elem: this.theList) {
            if (pred.apply(elem)) {
                newList.addLast(elem);
            }
        }
        return new FuncList<>(newList);
    }

    /**
     *
     * @param transform a function that returns some value on a single
     *                 element of the list
     * @return a list of the results of calling the provided function on
     * each element of the input list, in order
     * @param <R> the type of element in the output list
     */
    public <R> FuncList<R> map(Function<T,R> transform) {
        LinkedList<R> newList = new LinkedList<>();
        for (T elem: this.theList) {
            newList.addFirst(transform.apply(elem));
        }
        return new FuncList<>(newList);
    }

    /**
     * Execute function on all elements of the FuncList
     * @param todo Function to execute
     * @param <R> Return type
     */
    public <R> void forEach(Function<T,R> todo) {
        for (T elem: this.theList) {
            todo.apply(elem);
        }
    }

    /**
     *
     * @param pred a function from one element to boolean
     * @return the longest prefix of the list for which
     * the given function is true for every element in the prefix
     */
    public IFuncList<T> takeWhile(Function<T,Boolean> pred) {
        LinkedList<T> newList = new LinkedList<>();
        for (T elem: this.theList) {
            if (pred.apply(elem)) {
                newList.addLast(elem);
            } else {
                return new FuncList(newList);
            }
        }
        return new FuncList(newList);  // captures the empty output
    }

    /**
     *
     * @return a list of the unique elements in the list
     */
    public FuncList<T> distinct() {
        List<T> uniqueList = this.theList
            .stream() // get sequential stream
            .distinct() // distinct method
            .collect(Collectors.toList()); // collected to new unique list
        LinkedList<T> uniqueLL = new LinkedList<>();
        uniqueLL.addAll(uniqueList);
        return new FuncList<T>(uniqueLL);
    }

    /**
     *
     * @return the sum of the numbers in a list of Integers or Doubles.
     * If the list elements are not one of these types, throws
     * a RunTime Exception
     */
    public double sum() {
        if (this.isEmpty()) return 0;
        else if (this.first() instanceof Integer) {
            LinkedList<Integer> intList = (LinkedList<Integer>)this.theList;
            int sum = intList.stream().reduce(0, (a, b) -> a + b);
            return (double)sum;
        } else if (this.first() instanceof Double) {
            LinkedList<Double> dList = (LinkedList<Double>) this.theList;
            double sum = dList.stream().reduce(0.0, (a, b) -> a + b);
            return sum;
        }
        else throw new RuntimeException("sum requires list of Integer or Double");
    }

}
