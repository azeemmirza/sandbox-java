package Problem101;

import Problem101.employeebst.*;
import java.util.Comparator;

public class EmployeeBST {
    private Node root;
    private Comparator<Employee> comp;

    public EmployeeBST(Comparator<Employee> comp) {
        this.comp = comp;
    }

    public void insert(Employee e) {
        if (root == null) {
            root = new Node(e);
        } else {
            Node current = root;
            boolean inserted = false;
            
            while (!inserted) {
                if (comp.compare(e, current.data) < 0) {
                    if (current.left == null) {
                        current.left = new Node(e);
                        inserted = true;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current.right == null) {
                        current.right = new Node(e);
                        inserted = true;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
    }

    public void printTree() {
        if (root == null) {
            System.out.println("Empty tree");
        } else {
            printTree(root);
        }
    }

    private void printTree(Node node) {
        if (node != null) {
            printTree(node.left);
            System.out.println(node.data);
            printTree(node.right);
        }
    }

    private static class Node {
        Employee data;
        Node left, right;

        Node(Employee data) {
            this.data = data;
        }
    }
}