package Fila;

public class ex4 {
	
	public static void main(String[] args) {
		QStack a = new QStack();
		
		a.enqueue(4);
		a.enqueue(5);
		
		System.out.println(a.front());
		System.out.println(a.dequeue());
		System.out.println(a.front());
		
	}
}
