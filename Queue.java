package Pilha;

public class Queue {

	private int first;
	private int last;
	private int count;
	private int tam;
	private int queue[];
	
	private static final int QUEUE_CAPACITY = 10;
	
	public Queue(int tam) {
		this.queue = new int[tam];
		this.count = 0;
		this.first = 0;
		this.last = 0;
	}
	
	public Queue() {
		this(QUEUE_CAPACITY);
	}
	
	public void enqueue(int value) {
		if(!isFull()) {
			queue[last] = value;
			last = ++last % tam;
			count++;
		} else {
			System.out.println("Queue overflow");
		}
	}
	
	public int dequeue() {
		if(!isEmpty()) {
			int data = queue[first];
			first = ++first % tam;
			count--;
			return data;
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
			int l;
			if(last == 0) {
				l = tam-1;
			} else {
				l = last -1;
			}
			return queue[l];
		} else {
			System.out.println("Queue underflow");
			return -1;
		}
	}
	
	public int size() {
		return count;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public boolean isFull() {
		return count == tam;
	}
	
	public void clear() {
		for(int i = 0; i < tam; i++) {
			dequeue();
		}
	}
}
