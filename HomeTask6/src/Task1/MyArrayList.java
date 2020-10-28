package Task1;

public class MyArrayList {

    public int size(Object[] arr) {
        return arr.length;
    }

    public Object[] add(Object arr[], Object x) {
        int i;

        Object newarr[] = new Object[arr.length + 1];

        for (i = 0; i < arr.length; i++)
            newarr[i] = arr[i];

        newarr[arr.length] = x;

        return newarr;
    }

    public Object[] removeByIndex(Object[] arr, int index) {
        if (arr == null
                || index < 0
                || index >= arr.length) {

            return arr;
        }

        Object[] newArray = new Object[arr.length - 1];

        for (int i = 0, k = 0; i < arr.length; i++) {

            if (i == index) {
                continue;
            }
            newArray[k++] = arr[i];
        }

        return newArray;
    }

    public Object[] removeByElement(Object[] arr, Object item) {


        int count = 0;
        for (Object o : arr) {
            if (o == item)
                count++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item) {
                if (arr.length - 1 - i >= 0) System.arraycopy(arr, i + 1, arr, i, arr.length - 1 - i);
            }
        }
        Object[] newArray = new Object[arr.length - count];

        if (arr.length - count >= 0) System.arraycopy(arr, 0, newArray, 0, arr.length - count);

        return newArray;
    }

    public Object get (Object[] arr, int index) {
           return arr[index];
    }

    public Object[] clear(Object[] arr) {
        return arr = null;
    }
}
