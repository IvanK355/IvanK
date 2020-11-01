package Task2;

public abstract class Fruit {

    private float weight;
    private int qty;

    public Fruit(float weight, int qty) {
        this.weight = weight;
        this.qty = qty;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
