package Task2;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private final List<T> fruitList;
    private float totalWeight;

    public Box() {
        this.fruitList = new ArrayList<>();
    }

    public void addFruit(T item) {
        fruitList.add(item);
        totalWeight += item.getWeight();
    }

    public void removeFruit(T item) {
        totalWeight = totalWeight - item.getWeight();
    }

    public float getTotalWeight() {
        return totalWeight;
    }

    public boolean compare(Box box) {
        return this.getTotalWeight() == box.getTotalWeight();
    }

    public void transfer(Box <? super T> box) {
        box.fruitList.addAll(this.fruitList);
        clear();
        box.totalWeight = this.totalWeight;
        this.totalWeight = 0;
    }

    public void transferv2(Box<? super T> box) {

        for (T t : this.fruitList) {
            box.addFruit(t);
        }

        for (T t : this.fruitList) {
            this.removeFruit(t);
        }

        clear();

    }

    public void clear() {
        fruitList.clear();
    }

    public ArrayList<T> getBox () {

        return new ArrayList<>(fruitList);

    }
}
