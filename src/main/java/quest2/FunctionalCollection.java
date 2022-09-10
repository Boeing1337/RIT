package quest2;

import quest1.List;

import java.util.Comparator;
import java.util.function.Function;

public interface FunctionalCollection<E> extends List<E> {

    /**
     * creates new collection of the same type class and fill it with result of {@param function}
     * applying the function for each element and doesn't change order
     * <p>
     * Example
     * if we have such element ["A", "B", "C"] and function like ( e -> (int) e.charAt(0) )
     * method must produce a new collection [10, 11, 12]
     * <p>
     * 1) Order of elements should be the same
     * 2) Method must not crash if list contains null elements
     * 3)
     *
     * @param function function that must be applied
     * @param <T>      type of resulting collection
     * @return resulting collection
     */

    <T> FunctionalCollection<T> modify(Function<T, E> function);

    /**
     * Sort this list by ascending order. Null values must be considered as biggest values
     *
     * @return self (this)
     */
    FunctionalCollection<E> sort();


    /**
     * Sort this list by specified function.
     *
     * @return self (this)
     */
    FunctionalCollection<E> sortBy(Comparator<E> comparator);


}
