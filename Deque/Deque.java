package Deque;

public class Deque {
	
	private static final int MAX_CAPACITY = 100;
	private int first;
	private int last;
	private int count;
	private int deque[];
	
	public Deque(int tam) {
		first = last = count = 0;
		deque = new int[tam];
	}
	
	public Deque() {
		this(MAX_CAPACITY);
	}
	
	public void insertBack(int e) {
		if(!isFull()) {
			deque[last++] = e;
			last = last % deque.length;
			count++;
		} else {
			System.out.println("Deque overflow");
		}
	}
	
	public void insertFront(int e) {
		if(!isFull()) {
			first = (first - 1 + deque.length) % deque.length;
			deque[first] = e;
			count++;
		} else {
			System.out.println("Deque overflow");
		}
	}
	
	public int removeFront() {
		if(!isEmpty()) {
			int e = deque[first++];
			first %= deque.length;
			count--;
			return e;
		} else {
			System.out.println("Deque underflow");
			return -1;
		}
	}
	
	public int removeBack() {
		if(!isEmpty()) {
			last = (last - 1 + deque.length) % deque.length;
			int e = deque[last];
			count--;
			return e;
		} else {
			System.out.println("Deque underflow");
			return -1;
		}
	}
	
	public int front() {
		if(!isEmpty()) {
			return deque[first];
		} else {
			System.out.println("Deque underflow");
			return -1;
		}
	}
	
	public int back() {
		if(!isEmpty()) {
			return deque[(last - 1 + deque.length) % deque.length];
		} else {
			System.out.println("Deque underflow");
			return -1;
		}
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public boolean isFull() {
		return count == deque.length;
	}
	
	public int size() {
		return count;
	}
	
}
