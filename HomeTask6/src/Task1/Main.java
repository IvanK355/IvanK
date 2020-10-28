package Task1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        int n = 10;
        int i;

        // initial array of size 10
        Object arr[]
                = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // print the original array
        System.out.println("Initial Array:\n"
                + Arrays.toString(arr));

        // element to be added
        int x = 50;

        // call the method to add x in arr
        arr = myArrayList.add(arr, x);

        // print the updated array
        System.out.println("\nArray with " + x
                + " added:\n"
                + Arrays.toString(arr));

        System.out.println(myArrayList.size(arr));

    }
}
