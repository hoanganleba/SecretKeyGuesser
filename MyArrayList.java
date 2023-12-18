package Project.Ori;

public class MyArrayList<E> {

    private E[] elements;
    private int size;

    public MyArrayList() {
        size = 0;
        elements = (E[]) new Object[20];
    }

    /**
     * Best case - do not have to resize: Complexity O(1)
     * Worst case - have to resize when out of length: Complexity O(n)
     *
     * @param element E
     */
    public void add(E element) {
        if (size == elements.length) {
            elements =resizeArray(elements, elements.length*2); // Worst case: O(n)
        }
        elements[size++] = element; // Best case: O(1)
    }

//    /**
//     * Complexity O(n)
//     *
//     * @param element E
//     */
//    public void remove(E element) {
//        int index = indexOf(element); // Complexoty O(1)
//        if (index != -1) {
//            removeAt(index); // Complexity O(n)
//        }
//    }
//
//    public void removeAt(int index) {
//        if (index < 0 || index >= size) {
//            throw new IndexOutOfBoundsException("Index out of bounds");
//        }
//        System.out.println("Before remove:"+ Arrays.toString(elements));
//        System.arraycopy(elements, index + 1, elements, index, size - index - 1); // O(n)
//        System.out.println("After remove:"+ Arrays.toString(elements));
//        size--;
//    }

    /**
     * Complexity O(1)
     * @param index int
     * @return E
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return elements[index];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * System.arrayCopy() is not from Java Collection Framework. It is build-in method of Java
     * Complexity: O(n)
     *
     * @param oldArray
     * @param newLength
     * @return
     */
    public E[] resizeArray(E[] oldArray, int newLength) {
        E[] newArray = (E[]) new Object[newLength];  // O(1)
        int copyLength = Math.min(oldArray.length, newLength); // O(1)

        // Copy elements from the old array to the new array
        System.arraycopy(oldArray, 0, newArray, 0, copyLength); // Complexity: O(n)

        return newArray;
    }



    /**
     * Complexity O(n)
     *
     * @param element E
     * @return int
     */
    private int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < size; i++) {
            if (elements[i] != null){
                result.append(elements[i]);
                if (i != size - 1){
                    result.append(",");
                }
            }
        }
        result.append("]");
        return "MyArrayList{" +
                result +
                '}';
    }
}
