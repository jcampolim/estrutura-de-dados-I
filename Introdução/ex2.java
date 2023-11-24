package Introdução;

import java.util.Scanner;

public class ex2 {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Digite o horário de saída (hora minuto segundo): ");
		int hora = scan.nextInt();
		int minuto = scan.nextInt();
		int segundo = scan.nextInt();
		
		int saida = (((60*hora)+minuto)*60)+segundo;
		
		System.out.print("Digite o horário de entrada (hora minuto segundo): ");
		hora = scan.nextInt();
		minuto = scan.nextInt();
		segundo = scan.nextInt();
		
		int chegada = (((60*hora)+minuto)*60)+segundo;
		int diferenca = chegada - saida;
		
		hora = diferenca / 3600;
		diferenca = diferenca % 3600;
		minuto = diferenca / 60;
		segundo = diferenca % 60;
		
		double valor = (10*hora) + (0.2*minuto) + (0.02*segundo);
		
		System.out.printf("A viagem durou %d:%d:%d e custou %.2f", hora, minuto, segundo, valor);
		scan.close();
	}
}