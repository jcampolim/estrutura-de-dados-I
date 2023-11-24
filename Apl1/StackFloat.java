 package Apl1;

public class StackFloat {
	
	private int count;
	private int tam;
	private float stack[];
	
	private static final int MAX = 20;
	
	public StackFloat(int tam) {
		this.count = -1;
		this.setTam(tam);
		stack = new float[tam];
	}
	
	public StackFloat() {
		this(MAX);
	}
	
	public float pop() {
		if(isEmpty() == true) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			float top = stack[count];
			count--;
			return top;
		}
	}
	
	public void push(float value) {
		if(isFull() == true) {
			System.out.println("Stack Overflow");
		} else {
			stack[++count] = value;
		}
	}
	
	public float top() {
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
