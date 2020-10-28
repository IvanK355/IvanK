package Task1;

public class MyArrayList<E> {

    private int size = 0;
    private Object[] elementData;
    private int initialArraySize = 10;

    public MyArrayList() {
        this.elementData = new Object[initialArraySize];
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
        for (int to = size, i = size = 0; i < to; i++) {
            elementData[i] = null;
        }
    }

    public void remove(int i) {
        int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(elementData, i + 1, elementData, i, newSize - i);
        elementData[size = newSize] = null;
    }

    public void remove(Object o) {
        Object[] es = elementData;
        int size = this.size;
        int i = 0;
        found: {
            if (o == null) {
                for (; i < size; i++)
                    if (es[i] == null)
                        break found;
            } else {
                for (; i < size; i++)
                    if (o.equals(es[i]))
                        break found;
            }
        }
        remove(i);
    }
}
