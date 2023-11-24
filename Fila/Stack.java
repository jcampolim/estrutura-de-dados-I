package Fila;

public class Stack {
	private int count;
	private int tam;
	private int stack[];
	
	private static final int MAX = 30;
	
	public Stack(int tam) {
		this.count = -1;
		this.setTam(tam);
		stack = new int[tam];
	}
	
	public Stack() {
		this(MAX);
	}
	
	public int pop() {
		if(isEmpty() == true) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			int top = stack[count];
			count--;
			return top;
		}
	}
	
	public void push(int value) {
		if(isFull() == true) {
			System.out.println("Stack Overflow");
		} else {
			stack[++count] = value;
		}
	}
	
	public int top() {
		if(isEmpty() == true) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			return stack[count];
		}
	}
	
	public int size() {
		return count + 1;
	}
	
	public boolean isEmpty() {
		if(count == -1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isFull() {
		if(count == stack.length) {
			return true;
		} else {
			return false;
		}
	}
	
	public void clear() {
		for(int i = 0; i < size(); i++) {
			pop();
		}
		
		count = 0;
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}
}
