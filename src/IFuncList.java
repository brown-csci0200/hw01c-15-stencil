package src;

import java.util.function.Function;

/**
 * A functional list
 * @param <T>
 */
public interface IFuncList<T> {
    /**
     *
     * @param elem the element to add to the front of the list
     * @return a new list with elem followed by existing contents
     */
    public FuncList<T> link(T elem);

    /**
     *
     * @return true if the list has no elements
     */
    //*
    public boolean isEmpty();

    /**
     *
     * @return the number of elements in the list
     */
    public int size();

    /**
     *
     * @return the first item in the list, throwing a
     * Runtime Exception if the list is empty
     */
    public T first();

    /**
     *
     * @return the all but the first item in the list,
     * throwing a Runtime Exception if the list is empty
     */
    public IFuncList<T> rest();

    /**
     *
     * @param otherFL the list whose items should append to this one
     * @return a new FuncList with the contents of this followed by otherFL
     */
    public FuncList<T> append(FuncList<T> otherFL);

    /**
     *
     * @param pred a function from one element to boolean, indicating
     *            whether the element should appear in the output list
     * @return a list of all elements (in order) for which the given
     * function input returns true
     */
    public IFuncList<T> filter(Function<T,Boolean> pred);

    /**
     *
     * @param transform a function that returns some value on a single
     *                 element of the list
     * @return a list of the results of calling the provided function on
     * each element of the input list, in order
     * @param <R> the type of element in the output list
     */
    public <R> IFuncList<R> map(Function<T,R> transform);

    /**
     *
     * @param pred a function from one element to boolean
     * @return the longest prefix of the list for which
     * the given function is true for every element in the prefix
     */
    public IFuncList<T> takeWhile(Function<T,Boolean> pred);

    /**
     *
     * @return a list of the unique elements in the list
     */
    public FuncList<T> distinct();

    /**
     *
     * @return the sum of the numbers in a list of Integers or Doubles.
     * If the list elements are not one of these types, throws
     * a RunTime Exception
     */
    public double sum();
}