package CanalMultiplexado;

public class Queue {

	private int first;
	private int last;
	private int queue[];
	
	private static int QUEUE_CAPACITY = 30;
	
	public Queue(int tam) {
		this.queue = new int[tam];
		this.first = this.last = 0;
	}
	
	public Queue() {
		this(QUEUE_CAPACITY);
	}
	
	public void enqueue(int value) {
		if(!isFull()) {
			this.queue[this.last++] = value;
		} else {
			System.out.println("Queue overflow");
		}
	}
	
	public int dequeue() {
		if(!isEmpty()) {
			return this.queue[this.first++];
		} else {
			System.out.println("Queue underflow");
			return -1;
		}
	}
	
	public int front() {
		if(!isEmpty()) {
			return queue[first];
		} else {
			System.out.println("Queue underflow");
			return -1;
		}
	}
	
	public int rear() {
		if(!isEmpty()) {
			int qlast = this.last - 1;
			return this.queue[qlast];
		} else {
			System.out.println("Queue underflow");
			return -1;
		}
	}
	
	public int size() {
		if(!isEmpty()) return this.last - this.first;
		else return 0;
	}
	
	public boolean isEmpty() {
		return (this.first == this.last);
	}
	
	public boolean isFull() {
		return (this.last == QUEUE_CAPACITY);
	}
	
	public void clear() {
		for(int i = 0; i < QUEUE_CAPACITY; i++) {
			dequeue();
		}
	}
}
