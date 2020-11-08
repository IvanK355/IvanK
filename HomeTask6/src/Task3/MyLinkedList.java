package Task3;

public class MyLinkedList<E> {
    private int size = 0;

    private MyLinkedList.Node<E> first;
    private MyLinkedList.Node<E> last;

    private static class Node<E> {
        E item;
        MyLinkedList.Node<E> next;
        MyLinkedList.Node<E> prev;

        Node(MyLinkedList.Node<E> prev, E element, MyLinkedList.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public void clear() {
        first = last = null;
        size = 0;
    }

    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    public int size() {
        return size;
    }


    public void remove(Object o) {
        int size = this.size;
        for (int i = 0; i < size; i++) {
            if (o == null) break;
            if (o.equals(node(i).item)) {
                remove(i);
                break;
            }
        }
    }

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    private void linkLast(E e) {
        final MyLinkedList.Node<E> lastElement = last;
        final MyLinkedList.Node<E> newNode = new MyLinkedList.Node<>(lastElement, e, null);
        last = newNode;
        if (lastElement == null)
            first = newNode;
        else
            lastElement.next = newNode;
        size++;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private MyLinkedList.Node<E> node(int index) {

        Node<E> x;
        if (index < (size >> 1)) {
            x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
        } else {
            x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
        }
        return x;
    }


    private E unlink(MyLinkedList.Node<E> x) {
        final E element = x.item;
        final MyLinkedList.Node<E> next = x.next;
        final MyLinkedList.Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }


    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }
}
