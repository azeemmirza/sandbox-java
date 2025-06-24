package Practice;

import java.util.*;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
    }
}

public class DoublyLinkedList {
    Node head;

    // Insert at end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null)
            curr = curr.next;
        curr.next = newNode;
        newNode.prev = curr;
    }

    // Clone the list
    public DoublyLinkedList cloneList() {
        DoublyLinkedList clone = new DoublyLinkedList();
        Node curr = head;
        while (curr != null) {
            clone.insert(curr.data);
            curr = curr.next;
        }
        return clone;
    }

    // Print list
    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // ========= MERGE SORT =========
    public void mergeSort() {
        head = mergeSortRec(head);
    }

    private Node mergeSortRec(Node node) {
        if (node == null || node.next == null)
            return node;

        Node mid = getMiddle(node);
        Node next = mid.next;
        mid.next = null;
        if (next != null) next.prev = null;

        Node left = mergeSortRec(node);
        Node right = mergeSortRec(next);

        return merge(left, right);
    }

    private Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        if (a.data <= b.data) {
            a.next = merge(a.next, b);
            if (a.next != null) a.next.prev = a;
            a.prev = null;
            return a;
        } else {
            b.next = merge(a, b.next);
            if (b.next != null) b.next.prev = b;
            b.prev = null;
            return b;
        }
    }

    private Node getMiddle(Node node) {
        if (node == null) return node;
        Node slow = node, fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // ========= SELECTION SORT =========
    public void selectionSort() {
        for (Node i = head; i != null; i = i.next) {
            Node min = i;
            for (Node j = i.next; j != null; j = j.next) {
                if (j.data < min.data)
                    min = j;
            }
            int temp = i.data;
            i.data = min.data;
            min.data = temp;
        }
    }

    // ========= ARRAY SORT =========
    public void arraySort() {
        List<Integer> values = new ArrayList<>();
        Node curr = head;
        while (curr != null) {
            values.add(curr.data);
            curr = curr.next;
        }

        Collections.sort(values);

        curr = head;
        for (int val : values) {
            curr.data = val;
            curr = curr.next;
        }
    }

    // ========= MAIN TEST =========
    public static void main(String[] args) {
        int[] data = {42, 5, 18, 23, 7, 99, 3, 55, 12, 1};

        DoublyLinkedList original = new DoublyLinkedList();
        for (int num : data) {
            original.insert(num);
        }

        DoublyLinkedList listMerge = original.cloneList();
        DoublyLinkedList listSelect = original.cloneList();
        DoublyLinkedList listArray = original.cloneList();

        // MERGE SORT
        long start = System.nanoTime();
        listMerge.mergeSort();
        long end = System.nanoTime();
        System.out.println("Merge Sort: ");
        listMerge.printList();
        System.out.println("Time: " + (end - start) + " ns\n");

        // SELECTION SORT
        start = System.nanoTime();
        listSelect.selectionSort();
        end = System.nanoTime();
        System.out.println("Selection Sort: ");
        listSelect.printList();
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