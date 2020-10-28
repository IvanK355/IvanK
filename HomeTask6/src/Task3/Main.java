package Task3;

import Task1.MyArrayList;

public class Main {
    public static void main(String[] args) {

        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.add("1");
        arr.add("2");
        arr.add("50");
        arr.add("3");
        arr.add("4");
        arr.add("5");
        arr.add("6");
        arr.add("7");
        arr.add("8");
        arr.add("9");


        System.out.println("Initial size:" + arr.size());
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }

    }
}
