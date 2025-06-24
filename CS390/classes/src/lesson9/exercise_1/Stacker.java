package lesson9.exercise_1;

@SuppressWarnings("unused")
public class Stacker {
	private Node top;

	public void push(String s) {
		//implement
		Node newNode = new Node();
		newNode.data = s;
		newNode.next = top;  // point to the previous top
		top = newNode;
	}

	public String peek() {
		return top.toString();
	}

	public String pop() {
		Node currentTop = top;
		top = top.next;

		return currentTop.toString();
	}

	public static void main(String[] args) {
		Stacker stack = new Stacker();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		System.out.println(stack.peek());
		System.out.println(stack.top.toString());
		System.out.println(stack.pop());
		System.out.println(stack.top.toString());
	}

}
