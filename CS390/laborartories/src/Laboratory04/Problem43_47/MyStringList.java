package Laboratory04.Problem43_47;

import java.util.Arrays;

/**
 * A custom list implementation to store String objects.
 * Does not use Java's built-in List classes.
 */
public class MyStringList {
    private static final int INITIAL_CAPACITY = 2; // Initial size of the array
    private String[] strArray;
    private int size; // Number of actual elements in the list

    public MyStringList() {
        strArray = new String[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Adds a String to the end of the list.
     * Resizes the internal array if necessary.
     * @param s The String to add.
     */
    public void add(String s) {
        if (s == null) {
            return; // Or throw IllegalArgumentException
        }
        if (size == strArray.length) {
            resize();
        }
        strArray[size] = s;
        size++;
    }

    /**
     * Retrieves the String at the specified index.
     * @param i The index of the String to retrieve.
     * @return The String at index i.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public String get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }
        return strArray[i];
    }

    /**
     * Returns the number of elements in this list.
     * @return The number of elements.
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     * @return true if the list has no elements, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Resizes the internal array to twice its current capacity.
     */
    private void resize() {
        int newCapacity = strArray.length * 2;
        strArray = Arrays.copyOf(strArray, newCapacity);
        // System.out.println("MyStringList resized to capacity: " + newCapacity);
    }

    /**
     * Returns a string representation of the list.
     * Example: [Hello, World, Java]
     * @return String representation of the list.
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(strArray[i]);
            sb.append(", ");
        }
        sb.append(strArray[size - 1]);
        sb.append("]");
        return sb.toString();
    }

    // Optional: Method to remove an element (not strictly required by prompt but good for a list)
    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left.
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        String removedElement = strArray[index];
        for (int i = index; i < size - 1; i++) {
            strArray[i] = strArray[i + 1];
        }
        strArray[size - 1] = null; // Clear the last element
        size--;
        return removedElement;
    }
}
