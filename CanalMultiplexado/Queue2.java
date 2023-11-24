package CanalMultiplexado;

public class Queue2 {

	private int first;
	private int last;
	private int queue[][];
	
	private static int QUEUE_CAPACITY = 30;
	
	public Queue2(int tam) {
		this.queue = new int[tam][2];
		this.first = this.last = 0;
	}
	
	public Queue2() {
		this(QUEUE_CAPACITY);
	}
	
	public void enqueue(int i, int value) {
		if(!isFull()) {
			this.queue[this.last][0] = i;
			this.queue[this.last++][1] = value;
		} else {
			System.out.println("Queue overflow");
		}
	}
	
	public String dequeue() {
		if(!isEmpty()) {
			String d = "["+queue[first][0]+", "+queue[first][1]+"]";
			first++;
			return d;
		} else {
			System.out.println("Queue underflow");
			return "";
		}
	}
	
	public String front() {
		if(!isEmpty()) {
			return "["+queue[first][0]+", "+queue[first][1]+"]";
		} else {
			System.out.println("Queue underflow");
			return "";
		}
	}
	
	public int fluxo() {
		if(!isEmpty()) {
			return queue[first][0];
		} else {
			System.out.println("Queue underflow");
			return -1;
		}
	}
	
	public int valor() {
		if(!isEmpty()) {
			return queue[first][1];
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
