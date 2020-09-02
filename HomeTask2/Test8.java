import java.util.Arrays;

public class Test8 {
    public static void main(String[] args) {
        int[] array = {1,-10,5,6,45,23,-45,-34,0,32,56,-1,2,-2};
        int pol = 0;
        int neg = 0;
        int chetneg = 0;
        int kolpol = 0;
        int kolneg = 0;
        Arrays.sort(array);
        int arraylenght = array.length;
        for (int j : array) {
            if ((j < 0) && (j % 2 == 0)) {
                chetneg += j;
            }
            if (j > 0) {
                pol += j;
                kolpol++;
            } else if (j < 0) {
                neg += j;
                kolneg++;
            }
        }
        System.out.println(array[arraylenght-1]);
        System.out.println(pol);
        System.out.println(chetneg);
        System.out.println(kolpol);
        System.out.println(neg*1.0/kolneg);
    }
}
