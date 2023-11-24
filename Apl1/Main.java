package Apl1;

import java.util.Scanner;
import java.lang.Math;

public class Main {
	
	public static int prioridades(char c) {
		if(c == '+' || c == '-') {
			return 1;
		} else if(c == '*' || c == '/' ) {
			return 2;
		} else {
			return 3;
		}
	}
	
	public static String convertePosfixa(String infixa) {
		String posfixa = "";
		Stack pilha = new Stack();
		
		infixa = infixa.replaceAll("\\s+", "");
		
		for(int i = 0; i < infixa.length(); i++) {
			char c = infixa.charAt(i);
			
			if(Character.isAlphabetic(c)) {
				posfixa += c;
			} else if(c == '(') {
				pilha.push(c);
			} else if(c == ')') {
				while(pilha.top() != '(') {
					posfixa += pilha.pop();
				}
				pilha.pop();
			} else {
				int p = prioridades(c);
				while(!pilha.isEmpty() || p <= prioridades(pilha.top())) {
					posfixa += pilha.pop();
				}
				
				pilha.push(c);
			}
		}
		
		while(!pilha.isEmpty()) {
			posfixa += pilha.pop();
		}
		
		return posfixa;
	}
	
	public static String insereExpressao() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\nInsira a expressão infixa: ");
		String infixa = scan.nextLine();
		
		if(verifica(infixa)) {
			return infixa;
		} else {
			return "";
		}
	}
	
	public static boolean verifica(String expressao) {	
		StackFloat parenteses = new StackFloat();
		
		char c;
		
		expressao = expressao.replaceAll("\\s+", "");
		int tam = expressao.length();
		
		for(int i = 0; i < tam; i++) {
			
			c = expressao.charAt(i);
			
			if(Character.isDigit(c)) {
				return false;
			} else if(c == '(' || c == ')') {
				if(c == '(') {
					parenteses.push(i);
				} else if(c == ')'){
					if(parenteses.isEmpty()) {
						return false;
					} else {
						parenteses.pop();
					}
				}
			} else if(!Character.isAlphabetic(c)){
				if(c != '+' && c != '-' && c != '/' && c != '*' && c != '^') {
					return false;
				}
			}
		}
		
		if(parenteses.isEmpty()) {
			return true;
		}
		
		return false;
	}
	
	public static void associarValores(float variaveis[], String infixa) {
		Scanner scan = new Scanner(System.in);
		
		int tam = infixa.length();
		infixa = infixa.toUpperCase();
		
		for(int i = 0; i < tam; i++) {
			char c = infixa.charAt(i);
			
			int ascii = c;
			if(Character.isAlphabetic(c) && variaveis[ascii-65] == 0) {
						
				System.out.print("\nDigite o valor associado à variável "+c+": ");
				variaveis[ascii-65] = scan.nextInt();
			}
		}
	}
	
	public static float resolveExpressao(String posfixa, float variaveis[]) {
		int tam = posfixa.length();
		StackFloat pilha = new StackFloat();
		
		posfixa = posfixa.toUpperCase();
		
		for(int i = 0; i < tam; i++) {
			char c = posfixa.charAt(i);
			
			if(Character.isAlphabetic(c)) {
				pilha.push(variaveis[c-65]);
			} else {
				float a = pilha.pop();
				float b = pilha.pop();
				
				if(c == '+' || c == '-') {
					if(c == '+') {
						pilha.push(a+b);
					} else {
						pilha.push(b-a);
					}
				} else if(c == '*' || c == '/') {
					if(c == '*') {
						pilha.push(a*b);
					} else {
						if(a == 0) {
							System.out.println("Não é possível realizar divisões por 0!");
							return -1;
						} 
						pilha.push(b/a);
					}
				} else {
					float aux = (float)Math.pow(b,a);
					pilha.push(aux);
				}
			}
		}
		
		return pilha.pop();
	}
	
	public static void menu() {
		Scanner scan = new Scanner(System.in);
		
		int op;
		float variaveis[] = new float[26];
		String infixa = "", posfixa = "";
		
		do {
			System.out.println("\n-------- MENU --------");
			System.out.println("1. Inserir expressão aritmética.");
			System.out.println("2. Inserir valores associados às variáveis.");
			System.out.println("3. Converter expressão para posfixa.");
			System.out.println("4. Calcular expressão.");
			System.out.println("5. Encerrar programa.");
			
			System.out.print("\nEscolha a opção: ");
			op = scan.nextInt();
			
			if(op == 1) {
				infixa = insereExpressao();
				while(infixa == "") {
					System.out.println("Por favor digite um valor válido");
					infixa = insereExpressao();
				}
			} else if(op == 2) {
				if(infixa == "") {
					System.out.println("Por favor insira a expressão primeiro");
				}
				associarValores(variaveis, infixa);
			} else if(op == 3) {
				posfixa = convertePosfixa(infixa);
				System.out.println("\nA expressão "+infixa+" na forma posfixa é "+posfixa);
			} else if(op == 4) {
				if(infixa == "") {
					System.out.println("Por favor insira a expressão primeiro");
				} 
				if(posfixa == "") {
					posfixa = convertePosfixa(infixa);
				}
				
				float resp = resolveExpressao(posfixa, variaveis);
				System.out.println("\nO resultado da expressão é: "+resp);
			}
		} while(op != 5);
		
		scan.close();

	}

	public static void main(String[] args) {
		menu();
		System.out.println("\nConversor de expressões encerrado...");
 	}

}
