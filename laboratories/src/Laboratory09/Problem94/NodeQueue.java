package Laboratory09.Problem94;

public class NodeQueue {
	private Node head;
	private Node tail;
	public void enqueue(String s) {
		Node n = new Node();
		n.data = s;
		n.next = null;
		if( head == null){ //empty queue
			head = n;
			tail = n;
		}else{
			tail.next = n;
			tail = n;
		}

	}
	public String dequeue() throws QueueException {
		if(isEmpty()) throw new QueueException("Queue is empty!");
		String str = head.data;
		head = head.next;
		if(head == null) tail = null;
		return str;
	}
	public String peek() throws QueueException {
		if(isEmpty()) throw new QueueException("Queue is empty!");
		return head.data;
	}
	public boolean isEmpty() {
		return head == null;
	}
	@Override
	public String toString() {
		if(isEmpty()) return "<empty queue>";
		return head.toString();
	}
}


