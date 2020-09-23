package Task1;

import java.util.LinkedList;

public class LinkedListSample {

    static LinkedList<String> linkedList = new LinkedList<>();

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            linkedList.add("Item" + i);
        }
        System.out.println("Начальный массив ArrayList");

        for (String s : linkedList) {
            System.out.print(s + " ");
        }

        countSizeOfArrayList();
        addItemToArrayList("Item5");
        removeItemByIndexFronArrayList(5);
        removeItemByNameFromArrayList("Item3");
        getItemByIndexFronArrayList(5);
        clearArrayList();
    }

    private static void clearArrayList() {
        linkedList.clear();

        for (String s : linkedList) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("Удалили все элементы массива.");
    }

    private static void getItemByIndexFronArrayList(int i) {
        System.out.println();
        System.out.println(linkedList.get(i));
        System.out.println("Вывели " + (i + 1) + " элемент в массиве.");
    }

    private static void removeItemByNameFromArrayList(String i) {
        System.out.println();
        linkedList.remove(i);
        for (String s : linkedList) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("Удалили " + i + " в массиве.");
    }

    private static void removeItemByIndexFronArrayList(int i) {
        linkedList.remove(i);
        System.out.println();
        for (String s : linkedList) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("Удалили " + (i+1) + " позицию в массиве.");
    }

    private static void countSizeOfArrayList() {
        System.out.println();
        System.out.println("Размер массива ArrayList: " + linkedList.size());
    }

    private static void addItemToArrayList(String i) {

        linkedList.add(i);
        System.out.println();
        for (String s : linkedList) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("Добавили " + i + " в конец массива.");
    }
}

