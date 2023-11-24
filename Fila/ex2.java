package Fila;

public class ex2 {
	
	public static void removeNegativos(Queue q) {
		Queue aux = new Queue();
		
		int tam = q.size();
		for(int i = 0; i < tam; i++) {
			if(q.front() >= 0) {
				aux.enqueue(q.front());
			}
			q.dequeue();
			
		}
		
		tam = aux.size();
		for(int i = 0; i < tam; i++) {
			q.enqueue(aux.dequeue());
		}
	}

	public static void main(String[] args) {
		Queue q = new Queue();
		
		q.enqueue(5);
		q.enqueue(0);
		q.enqueue(-1);
		q.enqueue(6);
		q.enqueue(7);
				
		removeNegativos(q);
		
		int tam = q.size();
		
		for(int i = 0; i < tam; i++) {
			System.out.println(q.dequeue());
		}
	}

}
