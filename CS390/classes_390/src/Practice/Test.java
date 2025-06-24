package Practice;

public class Test {
  public static void main(String[] args) {
    System.out.println("testing xx");

    int[] data = {42, 5, 18, 23, 7, 99, 3, 55, 12, 1};

    DoublyLinkedList original = new DoublyLinkedList();
    for (int num : data) {
      original.insert(num);
    }

    DoublyLinkedList listMerge = original.cloneList();
    DoublyLinkedList listArray = original.cloneList();

    // MERGE SORT
    long start = System.nanoTime();
    listMerge.mergeSort();
    long end = System.nanoTime();
    System.out.println("Merge Sort: ");
    listMerge.printList();
    System.out.println("Time: " + (end - start) + " ns\n");

    // ARRAY SORT
    start = System.nanoTime();
    listArray.arraySort();
    end = System.nanoTime();
    System.out.println("Array Sort: ");
    listArray.printList();
    System.out.println("Time: " + (end - start) + " ns\n");
  }
}
