package Task1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        int n = 10;
        int i;

        // initial array of size 10
        Object arr[]
                = { 1, 50, 2, 3, 4, 50, 5, 6, 7, 8, 9, 10 };

        // print the original array
        System.out.println("Initial Array:\n"
                + Arrays.toString(arr));

        // element to be added
        Object x = 50;

        // call the method to add x in arr
        arr = myArrayList.add(arr, x);
        arr = myArrayList.add(arr, x);

        // print the updated array
        System.out.println("\nArray with " + x
                + " added:\n"
                + Arrays.toString(arr));

        System.out.println(myArrayList.size(arr));

        // Print the resultant array
        System.out.println("Original Array: "
                + Arrays.toString(arr));

        // Get the specific index
        int index = 2;

        // Print the index
        System.out.println("Index to be removed: "
                + index);

        // Remove the element
        arr = myArrayList.removeByIndex(arr, index);

        // Print the resultant array
        System.out.println("Resultant Array: "
                + Arrays.toString(arr));


        System.out.println("Original Array: "
                + Arrays.toString(arr));

        // Get the specific index
        Object item = 50;

        // Print the index
        System.out.println("Item to be removed: "
                + item);

        // Remove the element
        arr = myArrayList.removeByElement(arr, item);

        // Print the resultant array
        System.out.println("Resultant Array: "
                + Arrays.toString(arr));

    }
}
