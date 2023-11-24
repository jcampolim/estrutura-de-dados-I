package CanalMultiplexado;

import java.util.Scanner;

public class CanalMultiplexado {
	
	public static void preencher(int i, Queue q) {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nFluxo "+i+":");
		
		int value;
		while(true) {
			value = scan.nextInt();
			if(value == -1) {
				break;
			}
			q.enqueue(value);
		}
		
		System.out.println();
		
	}
	
	public static void imprimir(int n, Queue q) {
		System.out.print("\nFluxo "+n+": ");
		
		int tam = q.size();
		int aux;
		
		if(q.isEmpty()) {
			System.out.println("lista vazia!");
		} else {
			for(int i = 0; i < tam; i++) {
				aux = q.dequeue();
				System.out.print(aux+" ");
				q.enqueue(aux);
			}
		}
		
		System.out.println();
	}
	
	public static void canalCompartilhado(Queue fluxo1, Queue fluxo2, Queue fluxo3, Queue2 canal) {
		int aux, t1, t2, t3, tam = fluxo1.size();
		t1 = t2 = t3 = 0;
		
		if(fluxo2.size() > tam) {
			tam = fluxo2.size();
		}
		if(fluxo3.size() > tam) {
			tam = fluxo3.size();
		}
		
		for(int i = 0; i < tam; i++) {
			if(!fluxo1.isEmpty() && t1 < fluxo1.size()) {
				aux = fluxo1.dequeue();
				canal.enqueue(1, aux);
				fluxo1.enqueue(aux);
				t1++;
			}
			if(!fluxo2.isEmpty() && t2 < fluxo2.size()) {
				aux = fluxo2.dequeue();
				canal.enqueue(2, aux);
				fluxo2.enqueue(aux);
				t2++;
			}
			if(!fluxo3.isEmpty() && t3 < fluxo3.size()) {
				aux = fluxo3.dequeue();
				canal.enqueue(3, aux);
				fluxo3.enqueue(aux);
				t3++;
			}
		}
	}
	
	public static void imprimirCanal(Queue2 canal) {
		System.out.println();
		
		int tam = canal.size();
		
		if(tam == 0) {
			System.out.println("Fila vazia!");
		} else {
			String aux;
			int n, v;
			
			for(int i = 0; i < tam; i++) {
				n = canal.fluxo();
				v = canal.valor();
				aux = canal.dequeue();
				System.out.print(aux+" ");
				canal.enqueue(n, v);
			}
		}
		
		System.out.println();
	}
	
	public static void menu(Queue fluxo1, Queue fluxo2, Queue fluxo3, Queue2 canal) {
		Scanner scan = new Scanner(System.in);
		int op;
		
		while(true) {
			System.out.println("------- MENU DE OPÇÔES -------\n");
			System.out.println("1. Preencher fluxo 1.");
			System.out.println("2. Preencher fluxo 2.");
			System.out.println("3. Preencher fluxo 3.");
			System.out.println("4. Exibe estado atual dos fluxos.");
			System.out.println("5. Executa canal multiplexado.");
			System.out.println("6. Exibe canal multiplexado.");
			System.out.println("7. Encerrar aplicação.");
			System.out.print("\nOpção escolhida: ");
			
			op = scan.nextInt();
			
			if(op == 1) {
				preencher(1, fluxo1);
			} else if(op == 2) {
				preencher(2, fluxo2);
			} else if(op == 3) {
				preencher(3, fluxo3);
			} else if(op == 4) {
				imprimir(1, fluxo1);
				imprimir(2, fluxo2);
				imprimir(3, fluxo3);
			} else if(op == 5) {
				System.out.println("\nCanal multiplexado criado!\n");
				canalCompartilhado(fluxo1, fluxo2, fluxo3, canal);
			} else if(op == 6) {
				System.out.println();
				imprimirCanal(canal);
			} else if(op == 7) {
				System.out.println("\nEncerrando multiplexador...");
				break;
			}
	
		}
		
	}

	public static void main(String[] args) {
		Queue fluxo1 = new Queue();
		Queue fluxo2 = new Queue();
		Queue fluxo3 = new Queue();
		
		Queue2 canal = new Queue2();
		
		menu(fluxo1, fluxo2, fluxo3, canal);
 	}

}
