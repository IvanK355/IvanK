public class Test9 {
    public static void main(String[] args) {
        int[] array = {15, 10, 51, -6, -5, 3, -10, -34, 0, 32, 56, -12, 24, -52};
        int[] arraynew = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            arraynew[i] = array[array.length - i - 1];
        }

        for (int a : arraynew) {
            System.out.print(a + ",");
        }

    }
}
