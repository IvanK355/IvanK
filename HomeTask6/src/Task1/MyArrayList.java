package Task1;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<E> {


    private int size = 0;
    private Object[] elementData;

    public MyArrayList() {
        int initialArraySize = 0;
        this.elementData = new Object[initialArraySize];
    }

    private void add(E e, Object[] elementData, int s) {
        elementData[s] = e;
        size = s + 1;
    }

    public void add(E e) {
        grow();
        add(e, elementData, size);
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) elementData[index];
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
        int initialArraySize = 0;
        this.elementData = new Object[initialArraySize];
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        Object[] es = elementData;
        fastRemove(es, index);
    }

    public void remove(Object o) {
        Object[] es = elementData;
        int size = this.size;
        for (int i = 0; i < size; i++) {
            if (es[i].equals(o)) {
                fastRemove(es, i);
                break;
            }
        }
    }

    private void fastRemove(Object[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }

    private void grow(int minCapacity) {
        elementData = Arrays.copyOf(elementData, minCapacity);
    }

    private void grow() {
        grow(size + 1);
    }
}
