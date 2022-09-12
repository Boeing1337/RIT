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
        size--;
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
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) array[index];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E replace(E element, int index) {
        Object replaced = array[index];
        array[index] = element;
        return (E) replaced;
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
        shiftToTheLeft(index);
        return (E) removed;
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public void reduce() {
        for (int i = 0; i < size; i++) {
            if (array[i] == null) {
                shiftToTheLeft(i);
                i--;
            }
        }
        Object[] arr = array;
        array = new Object[size];
        System.arraycopy(arr, 0, array, 0, size);
    }

    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray(E[] newArray) {
        if (newArray.length < array.length) {
            newArray = (E[]) Arrays.copyOf(array, array.length, newArray.getClass());
        } else {
            System.arraycopy(array, 0, newArray, 0, array.length);
        }
        return newArray;

    }
}

