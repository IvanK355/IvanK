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

}
