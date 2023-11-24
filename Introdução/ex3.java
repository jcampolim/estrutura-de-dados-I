package Introdução;

import java.util.Scanner;

public class ex3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Valor de N: ");
		int n = scan.nextInt();
		
		int fatorial = 1;
		float e = 1;
		for(int i = 1; i <= n; i++) {
			fatorial *= i;
			e += 1.0/fatorial;
		}
		
		System.out.printf("E = %.2f", e);
		scan.close();
	}
}
