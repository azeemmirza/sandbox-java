package Laboratory10.Problem101.bst;

import Laboratory10.Problem101.employeebst.Employee;
import java.util.Comparator;

public class EmployeeBST {
  private Node root;
  Comparator<Employee> comparator;
  public EmployeeBST(Comparator<Employee> nameComp) {
    this.root = null;
    this.comparator = nameComp;
  }
  public void printTree() {
    if (root == null)
      System.out.println("Node is empty!");
    else
      printTree(root);
  }
  //helper printer
  private void printTree(Node n) {
    if (n != null) {
      printTree(n.left);
      System.out.println(n.element);
      printTree(n.right);
    }
  }
  //insert
  public void insert(Employee element) {
    if (root == null)
      root = new Node(element, null, null); //create new node
    else {
      Node n = root; // n as the root node
      boolean isInserted = false;
      while (!isInserted) { //until Insert is true
        int name_comparator = comparator.compare(element, n.element);// used name comparator method
        if (name_comparator < 0) { // go left
          if (n.left == null) { //left node is empty
            n.left = new Node(element); //insert new node on the left
            isInserted = true;
          } else { // left node is not empty
            n = n.left;
          }
        } else if (name_comparator > 0) { // go right
          if (n.right == null) {
            n.right = new Node(element);
            isInserted = true;
          } else {
            n = n.right;
          }
        }
      }
    }
  }
  //Node
  private class Node {
    private Employee element;
    private Node left;
    private Node right;
    public Node(Employee theElement, Node left, Node right) {
      this.element = theElement;
      this.left = left;
      this.right = right;
    }
    public Node(Employee e) {
      this(e, null, null);
    }
  }
}
