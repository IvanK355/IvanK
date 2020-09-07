public class Test10 {
    public static void main(String[] args) {

        int[] array = {15, 10, 0, -6, -5, 3, 0, -34, 0, 32, 56, 0, 24, -52};
        int j;

        for (int i = 0; i < array.length; i++) {
            int cell = array[i];
            if (cell == 0) {
                j = i + 1;
                while (j < array.length && array[j] == 0) {
                    j++;
                }
                if (j < array.length) {
                    array[i] = array[j];
                    array[j] = 0;
                }
            }
        }

        for (int k : array) {
            System.out.print(k + ",");
        }
    }
}
