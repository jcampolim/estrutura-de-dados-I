package Fila;

public class ex3 {

	public static void inverte(Queue q) {
		Stack aux = new Stack();
		
		int tam = q.size();
		for(int i = 0; i < tam; i++) {
			aux.push(q.dequeue());
		}
		
		tam = aux.size();
		for(int i = 0; i < tam; i++) {
			q.enqueue(aux.pop());
		}
	}

	public static void main(String[] args) {
		Queue q = new Queue();
		
		q.enqueue(5);
		q.enqueue(0);
		q.enqueue(-1);
		q.enqueue(6);
		q.enqueue(7);
			
		inverte(q);
		
		int tam = q.size();
		
		for(int i = 0; i < tam; i++) {
			System.out.println(q.dequeue());
		}
	}
}
