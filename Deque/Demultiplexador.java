package Deque;

import java.util.Scanner;

public class Demultiplexador {
	
	public static void leCanal(Deque2 canal) {
		Scanner scan = new Scanner(System.in);
		
		int i = 0, n;
		
		i = scan.nextInt();
		n = scan.nextInt();
		
		while(i != -1 && n != -1) {
			canal.insertBack(i, n);
			
			i = scan.nextInt();
			n = scan.nextInt();
		}
	}
	
	public static void imprimeCanal(Deque2 canal) {
		System.out.println("Canal compartilhado: ");
		
		int tam = canal.size();
		int i, v;
		
		if(tam == 0) {
			System.out.println("Canal vazio!");
		} else {
			for(int j = 0; j < tam; j++) {
				i = canal.indiceFront();
				v = canal.numeroFront();
				System.out.print(canal.removeFront()+" ");
				
				canal.insertBack(i, v);
			}
		}
	}
	
	public static void desenfileraElementos(Deque2 canal, Deque fluxo1, Deque fluxo2, Deque fluxo3) {
		int tam = canal.size();
		
		for(int i = 0; i < tam; i++) {
			if(canal.indiceFront() == 1) {
				fluxo1.insertBack(canal.numeroFront());
				canal.removeFront();
			} else if(canal.indiceFront() == 2) {
				fluxo2.insertBack(canal.numeroFront());
				canal.removeFront();
			} else if(canal.indiceFront() == 3) {
				fluxo3.insertBack(canal.numeroFront());
				canal.removeFront();
			}
		}
	}
	
	public static void imprimeFluxo(Deque fluxo, int i) {
		System.out.print("\nFluxo "+i+": ");
		
		int tam = fluxo.size();
		
		for(int j = 0; j < tam; j++) {
			int aux = fluxo.front();
			System.out.print(fluxo.removeFront()+" ");
			
			fluxo.insertBack(aux);
		}
	}

	public static void menu(Deque2 canal, Deque fluxo1, Deque fluxo2, Deque fluxo3) {
		Scanner scan = new Scanner(System.in);
		
		boolean controle = false;
		
		while(!controle) {
			System.out.println("-------- MENU --------\n");
			System.out.println("1. Preencher canal compartilhado.");
			System.out.println("2. Exibir estado atual do canal compartilhado.");
			System.out.println("3. Deenfilerar os elementos do canal compartilhado.");
			System.out.println("4. Exibir estado atual dos fluxos.");
			System.out.println("5. Encerrar programa.");
			System.out.println("\nEscolha uma opção: ");
			
			int op = scan.nextInt();
			
			if(op == 1) {
				System.out.println("Preenchendo canal compartilhado...");
				leCanal(canal);
			} else if(op == 2) {
				imprimeCanal(canal);
			} else if(op == 3) {
				desenfileraElementos(canal, fluxo1, fluxo2, fluxo3);
				System.out.println("Elementos desenfileirados com sucesso!");
			} else if(op == 4) {
				imprimeFluxo(fluxo1, 1);
				imprimeFluxo(fluxo2, 2);
				imprimeFluxo(fluxo3, 3);
			} else if(op == 5) {
				controle = true;
				System.out.println("Encerrando programa...");
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Deque2 canal = new Deque2(30);
		Deque fluxo1 = new Deque(30);
		Deque fluxo2 = new Deque(30);
		Deque fluxo3 = new Deque(30);
		
		menu(canal, fluxo1, fluxo2, fluxo3);
	}
}
