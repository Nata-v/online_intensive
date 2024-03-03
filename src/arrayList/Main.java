package arrayList;

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляр arrayList.MyArrayList для хранения целых чисел
        MyArrayList<Integer> myList = new MyArrayList<>();

        // Добавляем элементы в список
        myList.add(5);
        myList.add(10);
        myList.add(15);

        // Выводим размер списка
        System.out.println("Size of myList: " + myList.size());
        System.out.println();

        // Выводим все элементы списка
        for (int i = 0; i < myList.size(); i++) {
            System.out.println("Element at index " + i + ": " + myList.get(i));
        }
        System.out.println();
        // Получаем элемент по индексу и выводим его на консоль
        int index = 1;
        Integer element = myList.get(index);
        System.out.println("Element at index " + index + ": " + element);
        System.out.println();

        // Удаляем элемент по индексу
        myList.remove(1);

        // Выводим все элементы списка после удаления
        System.out.println("Size of myList after removal: " + myList.size());
        for (int i = 0; i < myList.size(); i++) {
            System.out.println("Element at index " + i + ": " + myList.get(i));
        }
        System.out.println();
        // Сортируем список
        myList.sort();

        // Выводим все элементы списка после сортировки
        System.out.println("Elements in myList after sorting:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println("Element at index " + i + ": " + myList.get(i));
        }

        System.out.println();
        if (myList.clear()) {
            System.out.println("Список успешно очищен и пуст.");
        } else {
            System.out.println("Внимание: список не очищен или не пуст.");
        }

    }
}
