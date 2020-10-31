package Task2;

public class Box<T> {

    private T[] fruits;
    private int qty;


    public Box() {
        fruits = (T[]) new Object[1000];
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

    public void add(T item) {

        fruits[qty++] = item;
    }

    public float getWeight(int qty, float weigth) {
        return qty * weigth;
    }

    public boolean compare(float weight1, float weight2) {
        boolean boo;
        if (weight1 >= weight2) boo = true;
        else boo = false;
        return boo;
    }
}
