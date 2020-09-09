import java.util.Arrays;

public class Test8 {
    public static void main(String[] args) {
        int[] array = {1, -10, 5, 6, 45, 23, -45, -34, 0, 32, 56, -1, 2, -2};
        int sumPositiveNumber = 0;
        int sumEvenNegativeNumber = 0;
        int sumNegativeNumber = 0;
        int qtyPositiveNumber = 0;
        int qtyNegativeNumber = 0;
        int arrayLength = array.length;

        Arrays.sort(array);

        for (int j : array) {
            if ((j < 0) && (j % 2 == 0)) {
                sumEvenNegativeNumber += j;
            }
            if (j > 0) {
                sumPositiveNumber += j;
                qtyPositiveNumber++;
            } else if (j < 0) {
                sumNegativeNumber += j;
                qtyNegativeNumber++;
            }
        }

        System.out.println(array[arrayLength - 1]);
        System.out.println(sumPositiveNumber);
        System.out.println(sumEvenNegativeNumber);
        System.out.println(qtyPositiveNumber);
        System.out.println(sumNegativeNumber * 1.0 / qtyNegativeNumber);
    }
}
