package Task1;

public class MyArrayList {

    private static int size;

    public int size(Object[] obj) {
        size = obj.length;
        return size;
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

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == item){
                // shifting elements
                for(int j = i; j < arr.length - 1; j++){
                    arr[j] = arr[j+1];
                }
                break;
            }
        }

        return arr;
    }
}
