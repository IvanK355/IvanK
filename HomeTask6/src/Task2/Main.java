package Task2;

public class Main {

    public static void main(String[] args) {

        double rnd;
        float box1BoxWeight = 0;
        float box2BoxWeight = 0;
        boolean overWeight;
        Box<Apple> box1 = new Box<>();
        Box<Orange> box2 = new Box<>();
        Apple apple = new Apple();
        Orange orange = new Orange();

        for (int i = 0; i < 1000; i++) {
            rnd = Math.random();
            if (rnd < 0.5) {
                box1.add(new Apple());
            } else box2.add(new Orange());

            box1BoxWeight = box1.getWeight(box1.getQty(), apple.getWeight());
            box2BoxWeight = box2.getWeight(box2.getQty(), orange.getWeight());
            overWeight = box1.compare(box1BoxWeight, box2BoxWeight);
            if (overWeight) {
                System.out.println("True, Box is ready");break;
            }
            else System.out.println("False. Box is filling");

        }

    }
}
