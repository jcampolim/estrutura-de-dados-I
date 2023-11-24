package Introdução;

import java.util.Scanner;

public class ex5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Números de elementos do vetor: ");
		int n = scan.nextInt();
		
		int vetor1[] = new int [n]; 
		for(int i = 0; i < n; i++) {
			System.out.printf("Posição nº %d: ", i+1);
			vetor1[i] = scan.nextInt();
		}
		
		int pos1 = 0, pos2 = 0;
		int vetor2[] = new int[2*n];
		int cont;
		
		while(pos1 < vetor1.length) {
			if(vetor1[pos1] != -1) {
				vetor2[pos2] = vetor1[pos1];
				cont = 0;
				
				for(int i = pos1; i < vetor1.length; i++) {
					if(vetor2[pos2] == vetor1[i]) {
						cont++;
						vetor1[i] = -1;
					}
				}
				pos2++;
				vetor2[pos2] = cont;
				pos2++;
			}
			pos1++;
		}
		
		for(int i = 0; i < pos2; i++) {
			System.out.printf("%d ", vetor2[i]);
		}
		scan.close();
	}
}