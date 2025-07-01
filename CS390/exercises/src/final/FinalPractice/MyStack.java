public class MyStack {
    private Node top;

    private class Node {
        Integer data;
        Node next;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(Integer val) {
        Node newNode = new Node();
        newNode.data = val;
        newNode.next = top;
        top = newNode;
    }

    public Integer peek() {
        if (top == null) throw new IllegalStateException("Stack is empty");
        return top.data;
    }

    public Integer pop() {
        if (top == null) throw new IllegalStateException("Stack is empty");
        int val = top.data;
        top = top.next;
        return val;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        System.out.println("Is empty? " + stack.isEmpty());

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); // should print 30
        System.out.println("Popped: " + stack.pop());       // should print 30
        System.out.println("Top element: " + stack.peek()); // should print 20
        System.out.println("Is empty? " + stack.isEmpty()); // should print false

        System.out.println("Popped: " + stack.pop());       // should print 20
        System.out.println("Popped: " + stack.pop());       // should print 10
        System.out.println("Is empty? " + stack.isEmpty()); // should print true
    }
}