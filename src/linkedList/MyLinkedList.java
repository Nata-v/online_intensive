package linkedList;
/**
 * Реализация связанного списка.
 * <p>
 * Этот класс реализует структуру данных связанного списка с базовыми операциями,
 * такими как добавление, удаление, получение элемента по индексу, сортировка и очистка.
 *
 * @param <E> тип элементов списка
 * @author Natallia Volkova
 */
public class MyLinkedList<E> {
    /**
     * Головной узел списка.
     */
    private Node<E> head;
    /**
     * Количество элементов в списке.
     */
    private int size;
    /**
     * Создает новый пустой связанный список.
     */
    public MyLinkedList() {
        head = null;
        size = 0;
    }
    /**
     * Добавляет указанный элемент в конец связанного списка.
     *
     * @param element элемент, который требуется добавить в список
     */
    public void add(E element) {
        // Создаем новый узел с указанным элементом
        Node<E> newNode = new Node<>(element);

        // Если список пустой, устанавливаем новый узел как головной узел списка
        if (head == null) {
            head = newNode;
        } else {
            // Если список не пустой, находим последний узел в списке
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            // Добавляем новый узел в конец списка
            current.next = newNode;
        }
        // Увеличиваем размер списка на 1
        size++;
    }
    /**
     * Добавляет элемент в связанный список по указанному индексу.
     * Если индекс меньше 0 или больше размера списка, выбрасывается
     * исключение {@link IndexOutOfBoundsException}.
     *
     * <p>Если индекс равен 0, элемент добавляется в начало списка.
     * Если индекс равен размеру списка, элемент добавляется в конец списка.
     * В противном случае, элемент добавляется в указанную позицию внутри списка.
     *
     * @param index индекс, по которому требуется добавить элемент
     * @param element элемент, который требуется добавить
     * @throws IndexOutOfBoundsException если индекс меньше 0 или больше размера списка
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            // Если индекс равен 0, добавляем элемент в начало списка
            Node<E> newNode = new Node<>(element);
            newNode.next = head;
            head = newNode;
        } else {
            // Иначе находим узел, предшествующий узлу с указанным индексом
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            // Создаем новый узел с указанным элементом и добавляем его в список
            Node<E> newNode = new Node<>(element);
            newNode.next = current.next;
            current.next = newNode;
        }
        // Увеличиваем размер списка на 1
        size++;
    }
    /**
     * Возвращает элемент по указанному индексу в связанном списке.
     * Если индекс меньше 0 или больше или равен размеру списка, выбрасывается
     * исключение {@link IndexOutOfBoundsException}.
     *
     * <p>Метод осуществляет проход по списку от начала до указанного индекса,
     * возвращая элемент, находящийся на этой позиции.
     *
     * @param index индекс элемента, который требуется получить
     * @return элемент, находящийся на указанной позиции в списке
     * @throws IndexOutOfBoundsException если индекс меньше 0 или больше или равен размеру списка
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        // Начинаем проход по списку от начала
        Node<E> current = head;
        // Проходим по списку до указанного индекса
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        // Возвращаем элемент на указанной позиции
        return current.data;
    }
    /**
     * Удаляет элемент из связанного списка по указанному индексу.
     * Если индекс выходит за границы допустимого диапазона (меньше нуля
     * или больше или равен размеру списка), выбрасывается исключение
     * {@link IndexOutOfBoundsException}.
     *
     * @param index индекс элемента, который требуется удалить
     * @throws IndexOutOfBoundsException если индекс выходит за границы допустимого диапазона
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            // Если индекс равен 0, удаляем элемент из начала списка
            head = head.next;
        } else {
            // В противном случае находим узел, предшествующий удаляемому узлу
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            // Пропускаем удаляемый узел, перенаправляя ссылку предшествующего узла

            current.next = current.next.next;
        }
        // Уменьшаем размер списка на 1
        size--;
    }
    /**
     * Очищает список, удаляя все его элементы.
     */
    public void clear() {
        // Устанавливаем головной узел в null
        head = null;
        // Сбрасываем размер списка
        size = 0;
    }
    /**
     * Возвращает количество элементов в списке.
     *
     * @return количество элементов в списке
     */
    public int size() {
        return size;
    }

    /**
     * Сортирует элементы списка в естественном порядке, используя сортировку вставками.
     * Если список пустой или содержит только один элемент, сортировка не выполняется.
     *
     * <p>Элементы списка должны быть сравнимы между собой через интерфейс Comparable.
     * Если элементы не сравнимы, будет выброшено исключение {@link ClassCastException}.
     *
     * <p>Сортировка происходит по возрастанию.
     */
    public void sort() {
        // Проверяем, пуст ли список или содержит только один элемент
        if (head == null || head.next == null) {
            return;
        }

        // Инициализируем новый список, в который будем вставлять элементы в отсортированном порядке
        Node<E> sortedList = null;
        Node<E> current = head;

        // Перебираем каждый элемент изначального списка
        while (current != null) {
            // Сохраняем ссылку на следующий элемент перед изменением указателя текущего элемента
            Node<E> next = current.next;

            // Вставляем текущий элемент в отсортированный список
            sortedList = insert(sortedList, current);

            // Переходим к следующему элементу в изначальном списке
            current = next;
        }

        // Обновляем указатель на начало списка после сортировки
        head = sortedList;
    }

    /**
     * Вставляет элемент в отсортированный список.
     *
     * @param sortedList отсортированный список, в который требуется вставить элемент
     * @param newNode элемент, который требуется вставить
     * @return обновленный отсортированный список с вставленным элементом
     */
    private Node<E> insert(Node<E> sortedList, Node<E> newNode) {
        // Если отсортированный список пустой или новый элемент должен быть вставлен в начало списка
        if (sortedList == null || ((Comparable<E>) newNode.data).compareTo(sortedList.data) <= 0) {
            newNode.next = sortedList;
            return newNode;
        }

        // Иначе ищем место для вставки нового элемента
        Node<E> current = sortedList;
        while (current.next != null && ((Comparable<E>) newNode.data).compareTo(current.next.data) > 0) {
            current = current.next;
        }

        // Вставляем новый элемент после текущего элемента
        newNode.next = current.next;
        current.next = newNode;

        return sortedList;
    }


    /**
     * Внутренний класс, представляющий узел списка.
     */
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
    /**
     * Выводит содержимое связанного списка на консоль.
     *
     * @param list связанный список, содержимое которого требуется вывести
     */
    public static void printList(MyLinkedList<Integer> list) {
        // Получаем размер списка
        int size = list.size();
        // Перебираем элементы списка и выводим их на консоль
        for (int i = 0; i < size; i++) {
            System.out.print(list.get(i) + " ");
        }
        // Печатаем пустую строку для перехода на новую строку
        System.out.println();
    }
}
