package Fila;

public class QStack {
	private int count;
	private int tam;
	private Stack memory;
	private Stack op;
	
	private static int MAX_CAPACITY = 10;
	
	public QStack(int tam) {
		this.memory = new Stack(tam);
		this.op = new Stack(tam);
		this.tam = tam;
		this.count = 0;
	}
	
	public QStack() {
		this(MAX_CAPACITY);
	}
	
	public void enqueue(int value) {
		if(!isFull()) {
			memory.push(value);
			count++;
		} else {
			System.out.println("Queue overflow");
		}
	}
	
	public int dequeue() {
		if(!isEmpty()) {
			int tam = memory.size();
			for(int i = 0; i < tam - 1; i++) {
				op.push(memory.pop());
			}
			
			int e = memory.pop();
			
			for(int i = 0; i < tam - 1; i++) {
				memory.push(op.pop());
			}
			
			return e;
			
		} else {
			System.out.println("Queue underflow");
			return -1;
		}
	}
	
	public boolean isFull() {
		if(count + 1 == tam) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isEmpty() {
		if(count == -1) {
			return true;
		} else {
			return false;
		}
	}
	
	public int size() {
		return count + 1;
	}
	
	public int front() {
		if(!isEmpty()) {
			int tam = memory.size();
			for(int i = 0; i < tam - 1; i++) {
				op.push(memory.pop());
			}
			
			int e = memory.top();
			
			for(int i = 0; i < tam - 1; i++) {
				memory.push(op.pop());
			}
			
			return e;
		} else {
			System.out.println("Queue underflow");
			return -1;
		}
	}
	
}
