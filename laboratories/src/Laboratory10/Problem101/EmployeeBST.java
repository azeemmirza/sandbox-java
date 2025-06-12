package Problem101;

import Problem101.employeebst.*;

public class EmployeeBST {
  private Node root;

  EmployeeBST() {
    root = null;
  }


  class Node {
    private final Employee employee;
    private final Node left;
    private final Node right;


    Node(Employee employee, Node left, Node right) {
      this.employee = employee;
      this.left = left;
      this.right = right;
    }

    Node(Employee employee) {
      this.employee = employee;
      this.left = null;
      this.right = null;
    }
  }
}
