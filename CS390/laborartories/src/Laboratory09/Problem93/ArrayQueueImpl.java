package Laboratory09.Problem93;


public class ArrayQueueImpl {
	private int[] arr = new int[10];
	private int size = 0;
	private int front = -1;
	private int rear = 0;
	
	public boolean isEmpty() {
		return size == 0;
	}
	public int size(){
		return size;
	}
	public void enqueue(int a){ //add new elements to arr
		if( rear == arr.length ) //arr is now full
			resize();
		if( front == -1) front = 0; //arr is empty
		arr[rear] = a; // enqueue an element to arr
		size++;
		rear++;
	}
	public void dequeue(){
		if(isEmpty()) throw new IllegalStateException("Cannot deque because Queue is empty!");
		arr[front] = 0; //remove from front
		front++;
		size--;
		if(isEmpty()){ //reset once arr is empty
			front = -1;
			rear = 0;
		}
	}
	public int peek(){
		if(isEmpty()) throw new IllegalStateException("Cannot peek because Queue is empty!");
		return arr[front];
	}
	public void resize(){
		int[] temp_arr = new int[arr.length * 2];
		System.arraycopy(arr, front, temp_arr,0,size);
		arr = temp_arr;
		front = 0; //arr is started from 0 again
		rear = size;
	}
	public static void main(String[] args) {
		ArrayQueueImpl q = new ArrayQueueImpl();
		for(int i = 0; i < 15; i ++)
			q.enqueue(i);
		for(int i = 0; i < 14; i ++)
			q.dequeue();
		System.out.println(q.size());
		System.out.println(q.peek());
	}
}

