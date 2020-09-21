package Test2;

public class Veterinar {

    public int age;
    public boolean sex; //true = m ; false = w

    public Veterinar(int age, boolean sex) {
        this.age = age;
        this.sex =sex;
    }

    public void treatAnimal(Animal animal) {
        System.out.println(animal.getClass().getTypeName() + " " + animal.food + " " + animal.location);
    }
}
