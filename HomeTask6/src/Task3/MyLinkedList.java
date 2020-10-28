package Task3;

public class MyLinkedList<E> {
    int size = 0;

    MyLinkedList.Node<E> first;
    MyLinkedList.Node<E> last;

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

    void linkLast(E e) {
        final MyLinkedList.Node<E> l = last;
        final MyLinkedList.Node<E> newNode = new MyLinkedList.Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    public E get(int index) {

        return node(index).item;
    }

    MyLinkedList.Node<E> node(int index) {

        if (index < (size >> 1)) {
            MyLinkedList.Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            MyLinkedList.Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    public int size() {
        return size;
    }


}
