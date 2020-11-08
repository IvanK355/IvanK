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

    public boolean add(E e) {
        grow();
        add(e, elementData, size);
        return true;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        return elementData(index);
    }

    public E elementData(int index) {
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

    public E remove(int index) {
        Objects.checkIndex(index, size);
        Object[] es = elementData;

        E oldValue = (E) es[index];
        fastRemove(es, index);

        return oldValue;
    }

    public boolean remove(Object o) {
        Object[] es = elementData;
        int size = this.size;
        for (int i = 0; i < size; i++) {
            if (es[i].equals(o)) {
                fastRemove(es, i);
                break;
            }
        }
        return true;
    }

    private void fastRemove(Object[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }

    private Object[] grow(int minCapacity) {
        return elementData = Arrays.copyOf(elementData, minCapacity);
    }

    private Object[] grow() {
        return grow(size + 1);
    }
}
