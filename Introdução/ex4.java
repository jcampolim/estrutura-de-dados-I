package Introdução;

import java.util.Scanner;

public class ex4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Número do elemento: ");
		int n = scan.nextInt();
		
		int f1 = 1;
		int f2 = 0;
		int aux;
		int soma = 1;
		
		for(int i = 0; i < n ; i++) {
			aux = f1;
			f1 = f2;
			f2 = f2 + aux;
			soma += f2;
		}
		
		System.out.printf("O número na posição %d é: %d", n, f2);
		System.out.printf("\nA soma dos elementos é: %d", soma);
		scan.close();
	}
}
