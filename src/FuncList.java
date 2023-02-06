package src;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FuncList<T> implements IFuncList<T> {
    private T type; // used to check the type of list element in sum

    private LinkedList<T> theList;

    public FuncList() {
        this.theList = new LinkedList<>();
    }

    private FuncList(LinkedList<T> initList) {
        this.theList = (LinkedList<T>)initList.clone();
    }

    public FuncList(Object... args) {
        this.theList = new LinkedList<>();
        for (int i = 0; i <= args.length - 1; i++) {
            this.theList.add((T)args[i]);
        }
    }


    public boolean equals(Object other) {
        if (other instanceof FuncList) {
            return this.theList.equals(((FuncList<T>) other).theList);
        } else return false;
    }

    public String toString() {
        return this.theList.toString();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int size() {
        return this.theList.size();
    }

    public FuncList<T> link(T elem) {
        LinkedList<T> newList = (LinkedList<T>) this.theList.clone();
        newList.addFirst(elem);
        return new FuncList<T>(newList);
    }

    public T first() {
        if (this.theList.size() > 0)
            return this.theList.getFirst();
        else throw new RuntimeException("List is Empty");
    }

    public FuncList<T> rest() {
        if (this.theList.size() > 0) {
            LinkedList<T> newList = (LinkedList<T>) this.theList.clone();
            newList.removeFirst();
            return new FuncList<T>(newList);
        }
        else throw new RuntimeException("List is Empty");
    }

    public FuncList<T> append(FuncList<T> toFL) {
        LinkedList<T> newList = (LinkedList<T>) this.theList.clone();
        newList.addAll(toFL.theList);
        return new FuncList<T>(newList);
    }

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

    public <R> FuncList<R> map(Function<T,R> transform) {
        LinkedList<R> newList = new LinkedList<>();
        for (T elem: this.theList) {
            newList.addFirst(transform.apply(elem));
        }
        return new FuncList<>(newList);
    }

    public <R> void forEach(Function<T,R> todo) {
        for (T elem: this.theList) {
            todo.apply(elem);
        }
    }

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

    public FuncList<T> distinct() {
        List<T> uniqueList = this.theList
            .stream() // get sequential stream
            .distinct() // distinct method
            .collect(Collectors.toList()); // collected to new unique list
        LinkedList<T> uniqueLL = new LinkedList<>();
        uniqueLL.addAll(uniqueList);
        return new FuncList<T>(uniqueLL);
    }

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
