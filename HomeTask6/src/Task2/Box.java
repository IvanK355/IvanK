package Task2;

public class Box<T>{

    private T[] fruits;
    private int qty;

    public Box() {
       fruits = (T[]) new Object[2];
    }

    public T getFruits(int index) {
        return fruits[index];
    }

    public void setFruits(T[] fruits) {
        this.fruits = fruits;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void add (T item){

        fruits[qty++] = item;
    }
}
