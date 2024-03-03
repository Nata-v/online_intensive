package linkedList;

import static linkedList.MyLinkedList.printList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(20);
        list.add(50);
        list.add(10);
        list.add(40);
        list.add(30);

        System.out.println("Выводим исходный список:");
        printList(list);
        System.out.println();

        list.add(0, 100);
        System.out.println("Выводим исходный список с новым добавленым элементом по индексу:");
        printList(list);
        System.out.println();


        list.get(1);
        System.out.println("Получаем элемент по индексу: " + list.get(1));
        System.out.println();

        System.out.println("Список до удаления:");
        printList(list);
        list.remove(2);
        System.out.println("\nСписок после удаления:");
        printList(list);
        System.out.println();

        System.out.println("Выводим список до сортировки:");
        printList(list);

        // Сортируем список
        list.sort();

        // Выводим отсортированный список
        System.out.println("\nОтсортированный список:");
        printList(list);
        System.out.println();

        list.clear();
        System.out.println("Размер списка после удаления всех элементов: " + list.size());

    }


}
