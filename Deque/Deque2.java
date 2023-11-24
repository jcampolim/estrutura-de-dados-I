package Deque;

public class Deque2 {
	
	private static final int MAX_CAPACITY = 100;
	private int first;
	private int last;
	private int count;
	private int deque[][];
	
	public Deque2(int tam) {
		first = last = count = 0;
		deque = new int[tam][2];
	}
	
	public Deque2() {
		this(MAX_CAPACITY);
	}
	
	public void insertBack(int i, int e) {
		if(!isFull()) {
			deque[last][0] = i;
			deque[last++][1] = e;
			last = last % deque.length;
			count++;
		} else {
			System.out.println("Deque overflow");
		}
	}
	
	public void insertFront(int i, int e) {
		if(!isFull()) {
			first = (first - 1 + deque.length) % deque.length;
			deque[first][0] = i;
			deque[first][1] = e;
			count++;
		} else {
			System.out.println("Deque overflow");
		}
	}
	
	public String removeFront() {
		if(!isEmpty()) {
			String e = "["+deque[first][0]+", "+deque[first++][1]+"]";
			first %= deque.length;
			count--;
			return e;
		} else {
			System.out.println("Deque underflow");
			return "";
		}
	}
	
	public String removeBack() {
		if(!isEmpty()) {
			last = (last - 1 + deque.length) % deque.length;
			count--;
			return "["+deque[(last - 1 + deque.length) % deque.length][0]+
					", "+deque[(last - 1 + deque.length) % deque.length][1]+"]";
		} else {
			System.out.println("Deque underflow");
			return "";
		}
	}
	
	public String front() {
		if(!isEmpty()) {
			return "["+deque[first][0]+", "+deque[first][1]+"]";
		} else {
			System.out.println("Deque underflow");
			return "";
		}
	}
	
	public String back() {
		if(!isEmpty()) {
			return "["+deque[(last - 1 + deque.length) % deque.length][0]+
					", "+deque[(last - 1 + deque.length) % deque.length][1]+"]";
		} else {
			System.out.println("Deque underflow");
			return "";
		}
	}
	
	public int indiceFront() {
		if(!isEmpty()) {
			return deque[first][0];
		} else {
			System.out.println("Deque underflow");
			return -1;
		}
	}
	
	public int numeroFront() {
		if(!isEmpty()) {
			return deque[first][1];
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
