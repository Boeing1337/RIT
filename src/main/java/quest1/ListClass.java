package quest1;

public class ListClass<E> implements List<E> {
    Object[] array = new Object[10];
    int size = 0;

    private void increaseSize() {
        Object[] arrayCopy = array;
        array = new Object[arrayCopy.length * 2];
        System.arraycopy(arrayCopy, 0, array, 0, array.length);
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


        return null;
    }

    @Override
    public E replace(E element, int index) {
        return null;
    }

    @Override
    public E remove(E element) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void reduce() {

    }

    @Override
    public E[] toArray(E[] array) {
        return array;
    }
}
