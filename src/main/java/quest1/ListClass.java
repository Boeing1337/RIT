package quest1;

import java.util.Arrays;

public class ListClass<E> implements List<E> {
    private Object[] array = new Object[10];
    private int size = 0;


    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    private void increaseSize() {
        array = Arrays.copyOf(array, array.length * 2);
    }

    private void shiftToTheLeft(int i) {
        System.arraycopy(array, i + 1, array, i, array.length - i - 1);
        array[array.length - 1] = null;
    }

    @Override
    public E add(E element) {
        if (size == array.length) {
            increaseSize();
        }
        array[size] = element;
        size++;
        return element;
    }

    @Override
    public E add(int index, E element) {
        if (size == array.length) {
            increaseSize();
        }
        System.arraycopy(array, index, array, index + 1, array.length - index - 1);
        array[index] = element;
        size++;

        return element;
    }

    @Override
    public E replace(E element, int index) {
        array[index] = element;
        return element;
    }

    @Override
    public E remove(E element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                shiftToTheLeft(i);
            }
        }
        return element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        Object removed = array[index];
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        array[array.length - 1] = null;
        return (E) removed;
    }

    @Override
    public int size() {
        int counter = 0;
        for (Object o : array) {
            if (o != null) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public void reduce() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                shiftToTheLeft(i);
            }
        }
    }

    @Override
    public E[] toArray(E[] arr) {
        System.arraycopy(array, 0, arr, 0, arr.length);
        return arr;
    }
}
