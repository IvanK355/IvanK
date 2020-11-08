package Task3;

public class Main {
    public static void main(String[] args) {

        MyLinkedList<String> arr = new MyLinkedList<>();

        arr.add("1");
        arr.add("2");
        arr.add("50");
        arr.add("3");
        arr.add("4");
        arr.add("5");
        arr.add("6");
        arr.add("7");
        arr.add("8");
        arr.add("9");

        System.out.println("Initial size:" + arr.size());
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }

        System.out.println();
        System.out.println("Убираем элемент" + " " + "50");
        arr.remove("50");
        System.out.println("Initial size:" + arr.size());
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }

        System.out.println();
        System.out.println("Убираем элемент c индексом 2");
        arr.remove(2);
        System.out.println("Initial size:" + arr.size());
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
        System.out.println("Очищаем массив");
        arr.clear();
        System.out.println("Initial size:\n"
                + arr.size());

        System.out.println("Снова добавляем элементы");
        arr.add("1");
        arr.add("2");
        arr.add("50");
        arr.add("3");
        arr.add("4");
        arr.add("5");
        arr.add("6");
        arr.add("7");
        arr.add("8");
        arr.add("9");

        System.out.println("Initial size:" + arr.size());
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }


    }
}
