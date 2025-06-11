package Laboratory08.Problem82;

public class MyStringLinkedList {
	Node header;
	private int size;

	MyStringLinkedList() {
		header = new Node(null);
		size = 0;
	}

	// inserts a new Node containing data so that its
	// position in the list is now pos
	void insert(String data, int pos) {

		if (pos < 0 || pos > size) {
			throw new IndexOutOfBoundsException("Invalid position");
		}
		// Locate a position to insert
		Node current = header;
		for (int i = 0; i < pos; i++) {
			current = current.next;
		}

		// Create new node and create links next and previous to existing nodes
		Node nextNode = current.next;
		Node newNode = new Node(data);

		// Break links between existing nodes and set next and previous links into N
		current.next = newNode;
		nextNode.previous = current;

		if (nextNode != null) {
			nextNode.previous = newNode;
		}

		newNode.next = nextNode;

		size++;
	}

	// attempts to remove the first Node that contains
	// data; if successful, returns true; otherwise, false.
	boolean remove(String data) {
		// Locate position of node to be deleted
		Node current = header.next;

		while (current != null) {
			if (current.value.equals(data)) {
				// Break links into and out of deleted node. Join deletednode.previous
				// and deletednode.next with links
				current.previous.next = current.next;
				current.next.previous = current.previous;

				size--;
				return true;
			}
			current = current.next;
		}

		return false;
	}

	/******* sorting methods ********/
	public void minSort() {
		if (header.next == null || size <= 1) {
			return;
		}

		Node current = header.next;

		while (current != null) {
			Node min = minNode(current);
			swap(current, min);
			current = current.next;
		}
	}

	void swap(Node n, Node n2) {
		String temp = n.value;
		n.value = n2.value;
		n2.value = temp;

	}

	// returns the Node nested in n that has the minimum value.
	Node minNode(Node n) {
		Node min = n;
		Node current = n.next;

		while (current != null) {
			if (current.value.compareTo(min.value) < 0) {
				min = current;
			}
			current = current.next;
		}
		return min;
	}

	// adds to the front of the list
	public void addFirst(String item) {
		Node n = new Node(item);
		// place new node after header and
		// establish links from new node to
		// surrounding nodes
		n.next = header.next;
		n.previous = header;

		// establish links from surrounding
		// nodes to the new node
		if (header.next != null) {
			header.next.previous = n;
		}
		header.next = n;
	}

	// adds to the end of the list
	public void addLast(String item) {
		Node n = new Node(item);

		// find last node
		Node last = header;

		while (last.next != null) {
			last = last.next;
		}
		// now last.next == null
		last.next = n;
		n.previous = last;
		size++;
	}

	// removes node in last position
	public void removeLast() {
		if (header.next == null)
			return;

		Node current = header;
		// traverse the list until current.next is
		// null - then remove current
		while (current.next != null) {
			current = current.next;
		}
		// now current.next == null, so remove current
		Node previous = current.previous;
		// previous is not null since current is not header
		previous.next = null;
		current.previous = null;
	}

	// determines whether the input string is in the list
	public boolean search(String s) {
		Node next = header.next;
		while (next != null && !next.value.equals(s)) {
			next = next.next;
		}
		// either next == null or next.value is s
		if (next == null)
			return false;
		else {// next.value.equals(s)
			return true;
		}
	}

	public String toString() {
		var sb = new StringBuffer();
		Node next = header.next;
		while (next != null) {
			sb.append(next.toString() + ", ");
			next = next.next;
		}
		var result = sb.toString().trim();
		if (result.length() == 0)
			return "<empty list>";
		if (result.charAt(result.length() - 1) == ',') {
			return result.substring(0, result.length() - 1);
		}
		return result;
	}

	class Node {
		String value;
		Node next;
		Node previous;

		Node(String value) {
			this.value = value;
		}

		public String toString() {
			return value == null ? "null" : value;
		}
	}

	public static void main(String[] args) {
		String[] testArr = { "big", "small", "tall", "short", "round", "square", "enormous", "tiny", "gargantuan",
				"lilliputian", "numberless", "none", "vast", "miniscule" };

		MyStringLinkedList list = new MyStringLinkedList();

		for (String s : testArr) {
			list.addLast(s);
		}

		list.minSort();

		System.out.println("The list in sorted order:");
		System.out.println(list.toString());
		System.out.println();
	}
}
