package Laboratory11.Problem113;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * A simple implementation of a hash table using separate chaining with LinkedLists.
 * Supports basic operations: put, get, remove, containsKey, and iteration over keys.
 */
@SuppressWarnings("rawtypes")
public class MyHashtable implements Iterable {

    private static final int INITIAL_SIZE;
    private static final int DEFAULT_LOAD_FACTOR = 5;

    static {
        INITIAL_SIZE = 20;
    }

    private int tableSize;
    private int numEntries;
    private int maxLoadFactor = DEFAULT_LOAD_FACTOR;
    private LinkedList[] table;

    /**
     * Constructs a hashtable with the default initial size.
     */
    public MyHashtable() {
        this(INITIAL_SIZE);
    }

    /**
     * Constructs a hashtable with the specified initial size.
     * @param tableSize the initial size of the table
     */
    public MyHashtable(int tableSize) {
        this.tableSize = tableSize;
        table = new LinkedList[tableSize];
    }

    /**
     * Checks whether the specified key exists in the table.
     * @param key the key to check
     * @return true if the key exists, false otherwise
     */
    public boolean containsKey(Object key) {
        if (key == null) return false;
        int index = hash(key.hashCode());
        if (table[index] == null) return false;

        for (Object obj : table[index]) {
            Entry e = (Entry) obj;
            if (e.key.equals(key)) return true;
        }
        return false;
    }

		/**
		 * Doubles the table size and rehashes all existing entries into the new table
		 * */
		private void rehash() {
			int newSize = 2 * tableSize;
			LinkedList[] tableTemp = new LinkedList[newSize];
			
			for (int i = 0; i < tableSize; i++) {
				if (table[i] != null) {
					for (Object obj : table[i]) {
						Entry oldEntry = (Entry) obj;
						int hash = Math.abs(oldEntry.key.hashCode() % newSize);
						
						if (tableTemp[hash] == null) {
							tableTemp[hash] = new LinkedList();
						}
						tableTemp[hash].add(oldEntry);
					}
				}
			}
			
			table = tableTemp;
			tableSize = newSize;
		}

    /**
     * Adds a key-value pair to the table or updates the value if the key already exists.
     * @param key the key
     * @param value the value
     */
    public void put(Object key, Object value) {
        if (key == null) return;
				
				if (loadFactor() >= maxLoadFactor) {
					rehash();
				}

        int hash = hash(key.hashCode());
        Entry e = getEntry(key);

        if (e != null) {
            e.value = value; // Update existing value
        } else {
            Entry newEntry = new Entry(key, value);
            if (table[hash] == null) {
                table[hash] = new LinkedList();
            }
            table[hash].add(newEntry);
            numEntries++;
        }
    }

    /**
     * Retrieves the value associated with a given key.
     * @param key the key to search
     * @return the value mapped to the key, or null if not found
     */
    public Object get(Object key) {
        if (key == null) return null;
        Entry e = getEntry(key);
        return (e == null) ? null : e.value;
    }

    /**
     * Removes the entry for a specified key from the table.
     * @param key the key to remove
     * @return the value associated with the removed key, or null if not found
     */
    public Object remove(Object key) {
        if (key == null || !containsKey(key)) return null;

        int hash = hash(key.hashCode());
        Iterator it = table[hash].iterator();
        Object value = null;
        Entry toRemove = null;

        while (it.hasNext()) {
            Entry e = (Entry) it.next();
            if (e.key.equals(key)) {
                value = e.value;
                toRemove = e;
                break;
            }
        }

        if (toRemove != null) {
            table[hash].remove(toRemove);
            numEntries--;
        }
        return value;
    }

    /**
     * Returns an iterator over all the keys in the hashtable.
     * @return an iterator over the keys
     */
    @Override
    public Iterator iterator() {
        ArrayList allKeys = new ArrayList();
        for (LinkedList bucket : table) {
            if (bucket != null) {
                for (Object obj : bucket) {
                    Entry e = (Entry) obj;
                    allKeys.add(e.key);
                }
            }
        }

        return new Iterator() {
            int index = 0;

            public boolean hasNext() {
                return index < allKeys.size();
            }

            public Object next() {
                return allKeys.get(index++);
            }

            public void remove() {
                throw new UnsupportedOperationException("Remove not supported");
            }
        };
    }

    /**
     * Returns a string representation of the hashtable's entries.
     * @return a formatted string showing all key-value pairs
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (LinkedList bucket : table) {
            if (bucket != null) {
                for (Object obj : bucket) {
                    Entry entry = (Entry) obj;
                    sb.append(entry.toString()).append(", ");
                }
            }
        }
        if (sb.length() > 1) sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }

    /**
     * Returns the Entry associated with a given key.
     * @param key the key to search
     * @return the Entry if found, otherwise null
     */
    private Entry getEntry(Object key) {
        if (key == null || !containsKey(key)) return null;

        int hash = hash(key.hashCode());
        for (Object obj : table[hash]) {
            Entry e = (Entry) obj;
            if (e.key.equals(key)) return e;
        }
        return null;
    }

    /**
     * Hash function to compress hashCode into a table index.
     * @param hashCode the raw hashCode
     * @return compressed index
     */
    private int hash(int hashCode) {
        return Math.abs(hashCode % tableSize);
    }

    /**
     * Computes the current load factor of the table.
     * @return the load factor
     */
    private int loadFactor() {
        return numEntries / tableSize;
    }

    /**
     * Represents a key-value pair stored in the hashtable.
     */
    private class Entry {
        private Object key;
        private Object value;

        Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return key + " -> " + value;
        }
    }

    /**
     * Test method for hashtable operations.
     */
    public static void main(String[] args) {

			System.out.println("================ MyHashtable ====================");
        MyHashtable h = new MyHashtable(4);

        // Insertion
        for (int i = 0; i < 100; ++i) {
            h.put(i, i);
        }

        System.out.println("Table size: " + h.tableSize);
        System.out.println("Number of entries: " + h.numEntries);
        System.out.println("Load factor: " + h.loadFactor());

        // Remove multiples of 2, 3, and 5
        for (int i = 0; i < 50; ++i) h.remove(2 * i);
        for (int i = 0; i < 33; ++i) h.remove(3 * i);
        for (int i = 0; i < 20; ++i) h.remove(5 * i);

        // Print final state
        System.out.println(h);
    }
}