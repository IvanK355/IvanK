package Task1;

public class Triangle implements Shape {

    private double sideA;
    private double sideB;
    private double sideC;


    @Override
    public double square() {

        double p = (sideA + sideB + sideC) / 2;
        double squareTriangle = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        System.out.println();
        System.out.println("Треугольник ");
        return Math.round(squareTriangle * 100) / 100.d;

    }

    public Triangle() {
        this.sideA = 2.0;
        this.sideB = 2.0;
        this.sideC = 2.0;
    }
}