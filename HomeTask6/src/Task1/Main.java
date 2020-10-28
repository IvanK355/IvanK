package Task1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();

        Object arr[] = {1, 50, 2, 3, 4, 50, 5, 6, 7, 8, 9, 10};

        System.out.println("Initial Array size:\n"+
                myArrayList.size(arr));

        System.out.println("Initial Array:\n"
                + Arrays.toString(arr));

        Object x = 50;

        arr = myArrayList.add(arr, x);
        arr = myArrayList.add(arr, x);

        System.out.println("\nArray with " + x
                + " added:\n"
                + Arrays.toString(arr));

        System.out.println("Original Array: "
                + Arrays.toString(arr));

        int index = 2;

        System.out.println("Index to be removed: "
                + index);

        arr = myArrayList.removeByIndex(arr, index);

        System.out.println("Resultant Array: "
                + Arrays.toString(arr));


        System.out.println("Original Array: "
                + Arrays.toString(arr));

          Object item = 50;

        System.out.println("Item to be removed: "
                + item);

        arr = myArrayList.removeByElement(arr, item);

        System.out.println("Resultant Array: "
                + Arrays.toString(arr));

        index = 5;

        System.out.println("Index to be shown: "
                + index);

        Object itemByIndex = myArrayList.get(arr, index);

        System.out.println("Resultant item: "
                + itemByIndex);

        System.out.println("Original Array: "
                + Arrays.toString(arr));

        arr = myArrayList.clear(arr);

        System.out.println("Resultant Array: "
                + Arrays.toString(arr));

    }
}
