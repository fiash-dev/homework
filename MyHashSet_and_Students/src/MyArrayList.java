import java.util.Arrays;
import java.util.Collection;

    public class MyArrayList<E> {
        private static final int DEFAULT_CAPACITY = 10;
        private Object[] elements;
        private int size;

        public MyArrayList() {
            elements = new Object[DEFAULT_CAPACITY];
            size = 0;
        }

        public boolean add(E element) {
            ensureCapacity();
            elements[size++] = element;
            return true;
        }

        public void add(int index, E element) {
            checkIndexForAdd(index);
            ensureCapacity();

            System.arraycopy(elements, index, elements, index + 1, size - index);
            elements[index] = element;
            size++;
        }

        // Добавление всех элементов коллекции
        public boolean addAll(Collection<? extends E> c) {
            for (E element : c) {
                add(element);
            }
            return !c.isEmpty();
        }

        // Получение элемента по индексу
        @SuppressWarnings("unchecked")
        public E get(int index) {
            checkIndex(index);
            return (E) elements[index];
        }

        // Удаление элемента по индексу
        public E remove(int index) {
            checkIndex(index);
            E oldValue = get(index);

            int numMoved = size - index - 1;
            if (numMoved > 0) {
                System.arraycopy(elements, index + 1, elements, index, numMoved);
            }

            elements[--size] = null; // Помощь сборщику мусора
            return oldValue;
        }

        // Удаление элемента по значению
        public boolean remove(Object o) {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    remove(i);
                    return true;
                }
            }
            return false;
        }

        public int size() {
            return size;
        }

        private void ensureCapacity() {
            if (size == elements.length) {
                int newCapacity = elements.length * 2;
                elements = Arrays.copyOf(elements, newCapacity);
            }
        }

        private void checkIndex(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
        }

        private void checkIndexForAdd(int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOf(elements, size));
        }
    }
