package Task1;

public class Main {
    public static void main(String[] args) {
        MyArrayList arr = new MyArrayList();

        arr.add(1);
        arr.add(2);


        System.out.println("Initial size:\n"
                + arr.size());
        for(int i=0;i< arr.size();i++) {
            System.out.print(arr.get(i)+" ");
        }


    }
}
