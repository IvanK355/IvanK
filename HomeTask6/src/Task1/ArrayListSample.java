package Task1;

import java.util.ArrayList;

public class ArrayListSample {

    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            ArrayListSample.arrayList.add(i);
        }
        System.out.println("Начальный массив ArrayList");

        for (int s : arrayList) {
            System.out.print(s + " ");
        }

        countSizeOfArrayList();
        addItemToArrayList(5);
        removeItemByIndexFronArrayList(5);
        removeItemByNameFromArrayList(3);
        getItemByIndexFronArrayList(5);
        clearArrayList();
    }

    private static void clearArrayList() {
        arrayList.clear();

        for (int s : arrayList) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("Удалили все элементы массива.");
    }

    private static void getItemByIndexFronArrayList(int i) {
        System.out.println();
        System.out.println(arrayList.get(i));
        System.out.println("Вывели " + (i+1) + " элемент в массиве.");
    }

    private static void removeItemByNameFromArrayList(Object i) {
        arrayList.remove(i);
        for (int s : arrayList) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("Удалили " + i + " в массиве.");
    }

    private static void removeItemByIndexFronArrayList(int i) {
        System.out.println();
        arrayList.remove(i);
        System.out.println();
        for (int s : arrayList) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("Удалили " + (i+1) + " позицию в массиве.");
    }

    private static void countSizeOfArrayList() {
        System.out.println();
        System.out.println("Размер массива ArrayList: " + arrayList.size());
    }

    private static void addItemToArrayList(int i) {

        arrayList.add(i);
        System.out.println();
        for (int s : arrayList) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("Добавили " + i + " в конец массива.");
    }
}



