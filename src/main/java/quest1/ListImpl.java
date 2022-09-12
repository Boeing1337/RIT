package quest1;

import static java.lang.String.format;
import static java.lang.System.arraycopy;
import static java.util.Arrays.copyOf;

@SuppressWarnings("unchecked")
public class ListImpl<E> implements List<E> {

    private Object[] content = new Object[10];
    private int size = 0;

    @Override
    public E add(E element) {
        growIfNeed();
        assign(size, element);
        return getByIndex(size++);
    }

    @Override
    public E add(int index, E element) {
        growIfNeed();
        throwIfOutOfBounds(index);
        shift(index, true);
        assign(index, element);
        size++;
        return getByIndex(index + 1);
    }

    private void growIfNeed() {
        if (content.length == size) {
            content = copyOf(content, content.length * 2);
        }
    }

    @Override
    public E get(int index) {
        return getByIndex(index);
    }

    @Override
    public E replace(E element, int index) {
        throwIfOutOfBounds(index);
        E replacedElement = getByIndex(index);
        assign(index, element);
        return replacedElement;
    }

    private void throwIfOutOfBounds(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(format("Index %s out of bounds of length %s", index, size));
        }
    }

    private void assign(int index, E element) {
        content[index] = element;
    }

    @Override
    public E remove(E element) {
        E replacedElement = null;
        if (element == null) return element;
        for (int i = 0; i < size; i++) {
            if (element.equals(content[i])) {
                replacedElement = getByIndex(i);
                shift(i, false);
                size--;
                break;
            }
        }
        return replacedElement;
    }

    @Override
    public E remove(int index) {
        E e = getByIndex(index);
        shift(index, false);
        assign(--size, null);
        return e;
    }

    private void shift(int index, boolean toRight) {
        if (toRight) {
            arraycopy(content, index, content, index + 1, content.length - index - 1);
        } else {
            arraycopy(content, index + 1, content, index - 1, content.length - index - 1);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void reduce() {
        int leftBorder = 0;
        for (int i = 0; i < size(); i++) {
            if (content[i] != null && i != 0) {
                content[leftBorder++] = getByIndex(i);
                assign(i, null);
            }
        }
        size = leftBorder;
    }

    private E getByIndex(int index) {
        return (E) content[index];
    }

    @Override
    public E[] toArray(E[] array) {
        if (array.length >= size) {
            arraycopy(content, 0, array, 0, size);
            return array;
        }
        return (E[]) copyOf(content, size, array.getClass());
    }


}
