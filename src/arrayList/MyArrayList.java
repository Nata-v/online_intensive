package arrayList;
/**
 * Реализация списка ArrayList.
 * <p>
 * Этот класс реализует структуру данных списка ArrayList с базовыми операциями,
 * такими как добавление, удаление, получение элемента по индексу, сортировка и очистка.
 *
 * @param <E> тип элементов списка
 * @author Natallia Volkova
 */
public class MyArrayList<E> {
    /**
     * Начальная ёмкость массива при создании списка.
     */
        private static final int INITIAL_CAPACITY = 10;
    /**
     * Массив для хранения элементов списка.
     */
        private Object[] array;
    /**
     * Текущий размер списка (количество элементов).
     */
        private int size;
    /**
     * Создает пустой список ArrayList с начальной емкостью 10.
     */
        public MyArrayList() {
            this.array = new Object[INITIAL_CAPACITY];
            this.size = 0;
        }
    /**
     * Добавляет элемент в конец списка.
     *
     * @param element элемент для добавления
     */
        public void add(E element) {
            if (size == array.length) {
                increaseCapacity();
            }
            array[size++] = element;
        }
    /**
     * Увеличивает емкость списка в два раза.
     * Создает новый массив с увеличенной емкостью и копирует все элементы из старого массива в новый.
     */
        private void increaseCapacity() {
            int newCapacity = array.length * 2;
            Object[] newArray = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
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
     * <p>Если массив, используемый для хранения элементов списка, заполнен,
     * его ёмкость увеличивается перед добавлением нового элемента.
     *
     * @param index индекс, по которому требуется добавить элемент
     * @param element элемент, который требуется добавить
     * @throws IndexOutOfBoundsException если индекс меньше 0 или больше размера списка
     */
        public void add(int index, E element) {
            // Проверяем, что индекс находится в допустимом диапазоне
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            // Проверяем, нужно ли увеличивать ёмкость массива
            if (size == array.length) {
                increaseCapacity();
            }
            // Копируем элементы после указанного индекса вправо на одну позицию
            System.arraycopy(array, index, array, index + 1, size - index);
            // Вставляем новый элемент на указанную позицию
            array[index] = element;
            // Увеличиваем размер списка на 1
            size++;
        }
    /**
     * Возвращает элемент по указанному индексу в связанном списке.
     * Если индекс меньше 0 или больше или равен размеру списка, выбрасывается
     * исключение {@link IndexOutOfBoundsException}.
     *
     * @param index индекс элемента, который требуется получить
     * @return элемент на указанной позиции в списке
     * @throws IndexOutOfBoundsException если индекс меньше 0 или больше или равен размеру списка
     */
        public E get(int index) {
            // Проверяем, что индекс находится в допустимом диапазоне
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            // Возвращаем элемент на указанной позиции в списке
            return (E) array[index];
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
            // Проверяем, что индекс находится в допустимом диапазоне
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            // Сдвигаем элементы влево, чтобы удалить элемент по указанному индексу
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            // Уменьшаем размер списка на 1
            size--;
        }


    /**
     *
     * Этот метод реализует сортировку выбором (selection sort) для списка.
     * Он проходит по всем элементам списка и находит минимальный элемент,
     * сравнивая каждый элемент с текущим минимальным элементом.
     * Затем он меняет местами минимальный элемент с первым элементом списка.
     * После этого он продолжает процесс сортировки для оставшихся элементов списка,
     * начиная со второго элемента.
     *
     * <p>Элементы списка должны быть сравнимы между собой (сравнение происходит через интерфейс Comparable).
     *
     * <p>Сортировка происходит по возрастанию.
     */
        public void sort() {
            for (int i = 0; i < size - 1; i++) {
                // Находим индекс минимального элемента в оставшейся части списка
                int minIndex = i;
                for (int j = i + 1; j < size; j++) {
                    if (((Comparable<E>) array[j]).compareTo((E) array[minIndex]) < 0) {
                        minIndex = j;
                    }
                }
                // Обмениваем минимальный элемент с текущим элементом
                E temp = (E) array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    /**
     * Очищает список, удаляя все его элементы.
     * Устанавливает все элементы массива в null и сбрасывает размер списка на 0.
     *
     * @return true, если список успешно очищен, в противном случае false
     */
    public boolean clear() {

        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        return true;
    }
    /**
     * Возвращает текущий размер списка.
     *
     * @return текущий размер списка
     */
        public int size() {
            return size;
        }

}
