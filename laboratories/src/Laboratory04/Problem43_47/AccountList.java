package Laboratory04.Problem43_47;

import Laboratory04.Problem43_47.employeeinfo.Account;

import java.util.Arrays;

/**
 * A custom list implementation to store Account objects.
 * Does not use Java's built-in List classes.
 * Based on MyStringList.
 */
public class AccountList {
    private static final int INITIAL_CAPACITY = 2; // Initial size of the array
    private Account[] accArray;
    private int size; // Number of actual elements in the list

    public AccountList() {
        accArray = new Account[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Adds an Account to the end of the list.
     * Resizes the internal array if necessary.
     * @param acct The Account to add.
     */
    public void add(Account acct) {
        if (acct == null) {
            return; // Or throw IllegalArgumentException
        }
        if (size == accArray.length) {
            resize();
        }
        accArray[size] = acct;
        size++;
    }

    /**
     * Retrieves the Account at the specified index.
     * @param i The index of the Account to retrieve.
     * @return The Account at index i.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public Account get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }
        return accArray[i];
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
        int newCapacity = accArray.length * 2;
        accArray = Arrays.copyOf(accArray, newCapacity);
        // System.out.println("AccountList resized to capacity: " + newCapacity);
    }

    /**
     * Returns a string representation of the list of accounts.
     * Calls toString() on each Account object.
     * @return String representation of the list.
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[\n");
        for (int i = 0; i < size; i++) {
            sb.append("  ").append(accArray[i].toString()); // Assuming Account has a decent toString()
            if (i < size - 1) {
                sb.append(",\n");
            }
        }
        sb.append("\n]");
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
    public Account remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Account removedElement = accArray[index];
        for (int i = index; i < size - 1; i++) {
            accArray[i] = accArray[i + 1];
        }
        accArray[size - 1] = null; // Clear the last element
        size--;
        return removedElement;
    }
}

