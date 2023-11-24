package Introdução;

import java.util.Scanner;

public class ex1 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Quantidade de tanques: ");
		int m = s.nextInt();
		
		double volume = 0;
		for(int i = 0; i < m; i++) {
			System.out.printf("\nAltura do tanque %d: ", i+1);
			double h = s.nextDouble();
			
			System.out.printf("Raio do tanque %d: ", i+1);
			double r = s.nextDouble();
			
			volume += Math.PI * 1000 * Math.pow(r, 2) * h;
		}
		
		double qtidade = volume/200;
		
		System.out.printf("\nSerão necessários %d barris", (int)Math.ceil(qtidade));
		s.close();
	}

}