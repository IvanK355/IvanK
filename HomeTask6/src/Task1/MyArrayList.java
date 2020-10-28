package Task1;

public class MyArrayList {

   int size;

   int size(Object[] obj){
       size = obj.length;
       return size;
   }

    public static Object[] add(Object arr[], Object x)
    {
        int i;

        // create a new array of size n+1
        Object newarr[] = new Object[arr.length + 1];

        // insert the elements from
        // the old array into the new array
        // insert all elements till n
        // then insert x at n+1
        for (i = 0; i < arr.length; i++)
            newarr[i] = arr[i];

        newarr[arr.length] = x;

        return newarr;
    }
}
