package Task1;

public class Circle implements Shape {

    private double radiusCircle;

    public Circle() {
        this.radiusCircle = 5.2;
    }

    @Override
    public double square() {
        System.out.println();
        System.out.println("Круг ");

        return Math.round(radiusCircle * Math.PI*100)/100.d;

    }

}