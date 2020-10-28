package Task1;

import java.util.Objects;

public class MyArrayList<E> {

    private int size = 0;
    private Object[] elementData;

    public MyArrayList() {
        this.elementData = new Object[10];
    }

    private void add(E e, Object[] elementData, int s) {
        elementData[s] = e;
        size = s + 1;
    }

    public boolean add(E e) {
        add(e, elementData, size);
        return true;
    }

    public E get(int index) {
        return (E) elementData[index];
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
    }

    public void remove(int i) {
        int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(elementData, i + 1, elementData, i, newSize - i);
        elementData[size = newSize] = null;
    }
}
