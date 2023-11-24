package Pilha;

public class Stack {
	
	private int count;
	private int tam;
	private char stack[];
	
	private static final int MAX = 100;
	
	public Stack(int tam) {
		this.count = -1;
		this.setTam(tam);
		stack = new char[tam];
	}
	
	public Stack() {
		this(MAX);
	}
	
	public char pop() {
		if(isEmpty() == true) {
			System.out.println("Stack Underflow");
			return 'b';
		} else {
			char top = stack[count];
			count--;
			return top;
		}
	}
	
	public void push(char value) {
		if(isFull() == true) {
			System.out.println("Stack Overflow");
		} else {
			stack[++count] = value;
		}
	}
	
	public char top() {
		if(isEmpty() == true) {
			System.out.println("Stack Underflow");
			return 'b';
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
