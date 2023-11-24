package Josephus;

import java.util.Scanner;
import java.util.Random;

public class Main {
	
	//Função para inserir novos soldados na lista encadeada circular.
	public static void insertSoldier(CircleLinkedList soldiers) {
		Scanner scan = new Scanner(System.in);
		int op = 1, code;
		String name, aux;
		
		//Enquanto o usuário escolher a opção 1 (adicionar mais soldados).
		while(op == 1) {
			
			//Recolhe as informações do soldado, verificando se o código é um número inteiro.
			System.out.print("Nome do soldado: ");
			name = scan.next().trim();
			scan.nextLine();

			System.out.print("Código do soldado: ");
			
			aux = scan.next();
			scan.nextLine();

			code = -1;
			while(code == -1) {
				try {
					code = Integer.parseInt(aux);
				} catch(Exception e) {
					System.out.println("Por favor, insira um valor inteiro.");
					System.out.print("Código do soldado: ");
					aux = scan.next();
				}
			}

			//Insere o novo soldado na lista encadeada.
			soldiers.insert(name, code);
			System.out.print("\nSoldado " + name + " adicionado com sucesso!\n"
					+ "\nDeseja continuar? SIM:1 NÃO:2 ");

			op = 0;
			while(op != 1 && op != 2) {
				aux = scan.next();
				try {
					op = Integer.parseInt(aux);
					if(op != 1 && op != 2) {
						System.out.println("\nPor favor, insira um valor válido.");
						System.out.print("Deseja continuar? SIM:1 NÃO:2 ");
					}
				} catch (Exception e) {
					System.out.println("\nPor favor, insira um valor inteiro.");
					System.out.print("Deseja continuar? SIM:1 NÃO:2 ");
				}
			}
			System.out.println();
		}
	}
	
	//Função para remover soldado da lista encadeada circular.
	public static void removeSoldier(CircleLinkedList soldiers) {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		//Recolhe o nome do primeiro soldado e verifica sua posição na lista.
		System.out.print("Digite o nome do primeiro soldado: ");
		String name = scan.next();
		System.out.println();
		
		boolean search = soldiers.search(name);
		
		while(!search) {
			System.out.print("Nome inválido, por favor tente novamente: ");
			name = scan.next();
			
			search = soldiers.search(name);
		}
				
		//Sorteia um novo número aleatório e remove o soldado dessa posição.
		while(soldiers.getCount() > 1) {
			int n = random.nextInt(100);
			soldiers.remove(n);
		}
		
		System.out.println("O soldado " + soldiers.getHeadName() + " de código " + 
				+ soldiers.getHeadCode() + " foi salvo e vai pegar o cavalo!");
	}
	
	//Função menu
	public static void menu() {
		//Declara as variáveis de opção, flag1 (verifica se a lista foi criada) 
		//e flag2 (verifica se os soldados foram inseridos).
		int op = 0, flag1 = 0, flag2 = 0;
		CircleLinkedList soldiers = new CircleLinkedList();
		Scanner scan = new Scanner(System.in);
		
		while(op != 5) {
			System.out.println("--------- MENU ---------\n");
			System.out.println("1) Iniciar.");
			System.out.println("2) Inserir soldado.");
			System.out.println("3) Mostrar soldados.");
			System.out.println("4) Retirar soldado.");
			System.out.println("5) Sair");
			
			System.out.print("\nOpção: ");
			op = 0;
			while(op < 1 || op > 5) {
				op = 0;
				try {
					op = scan.nextInt();
					if(op < 1 || op > 5) {
						System.out.println("\nPor favor, insira um valor válido.");
						System.out.print("Opção: ");
					}
				} catch(Exception e) {
					System.out.println("\nPor favor, insira um valor inteiro.");
					System.out.print("Opção: ");
					scan.next();
				}
			}

			if(op == 1) {
				soldiers = new CircleLinkedList();
				System.out.println("Lista de soldados criada com sucesso!");
				
				if(flag1 == 0) {
					flag1 = 1;
				} else {
					flag2 = 0;
				}
			} else if(op == 2) {
				if(flag1 == 1) {
					insertSoldier(soldiers);
					flag2 = 1;
				} else {
					System.out.println("Por favor, inicie a lista antes.");
				}
			} else if(op == 3) {
				if(flag2 == 1) {
					System.out.print(soldiers);
				} else {
					System.out.println("Por favor, insira os soldados antes.");
				}
			} else if(op == 4) {
				if(flag2 == 1) {
					removeSoldier(soldiers);
					flag2 = flag1 = 0;
				} else {
					System.out.println("Por favor, insira os soldados antes.");
				}
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Iniciando programa...");
		menu();
		System.out.println("Programa encerrado...");
	}
	
}
