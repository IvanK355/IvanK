package Task1;

public class Rectangle implements Shape {

    private double sideA;
    private double sideB;

    public Rectangle() {
        this.sideA = 5.1;
        this.sideB = 6.2;
    }

    @Override
    public double square() {
        System.out.println();
        System.out.println("Прямоугольник ");

        return Math.round(sideA * sideB * 100) / 100.d;
    }
}