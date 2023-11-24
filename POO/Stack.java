package POO;

public class Stack<T> {
	
	private int count;
	private int tam;
	private T[] stack;
	
	private static int MAX = 10;
	
	@SuppressWarnings("unchecked")
	public Stack(int tam) {
		this.count = -1;
		this.tam = tam;
		stack = (T[]) new Object[tam];
	}
	
	public Stack() {
		this(MAX);
	}
	
	public T pop() {
		if(isEmpty() == true) {
			System.out.println("Stack Underflow");
			return null;
		} else {
			T top = stack[count];
			stack[count--] = null;
			return top;
		}
	}
	
	public void push(T value) {
		if(isFull() == true) {
			System.out.println("Stack Overflow");
		} else {
			stack[++count] = value;
		}
	}
	
	public T top() {
		if(isEmpty() == true) {
			System.out.println("Stack Underflow");
			return null;
		} else {
			return stack[count];
		}
	}
	
	public int size() {
		return tam;
	}
	
	public int count() {
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
		for(int i = 0; i < count(); i++) {
			pop();
		}
		
		count = 0;
	}
	
	public static void main(String[] args) {
		Stack<Integer> a = new Stack<Integer>(5);
		a.push(8);
		a.pop();
		
		System.out.println(a.count());
	}

}
