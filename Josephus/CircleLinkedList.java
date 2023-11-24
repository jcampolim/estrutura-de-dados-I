package Josephus;

//Erika Borges Piaui - 32284683
//João Pedro Zavanela Andreu - 42246271
//Júlia Campolim de Oste - 42201691

//Cria a classe para a lista encadeada circular.
public class CircleLinkedList {
	
	private Node head;
	private int count;
	
	public CircleLinkedList() {
		head = null;
		count = 0;
	}
	
	public int getCount() {
		return count;
	}
	
	//getHeadName e getHeadCode são necessários para exibir, de forma facilitada,
	//o nome e código do soldado que sobreviveu.
	public String getHeadName() {
		return head.getSoldierName();
	}
	
	public int getHeadCode() {
		return head.getSoldierCode();
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public boolean isFull() {
		Node aux = new Node();
		return aux == null;
	}
	
	//Insere um elemento no começo da lista.
	public boolean insert(String soldierName, int soldierCode) {
		if(isFull()) return false;
		
		Node node = new Node(soldierName, soldierCode, null);
		if(isEmpty()) {
			head = node;
			node.setNext(node);		
		} else {
			node.setNext(head);
			head = node;

			Node aux = head;
			for(int i = 0; i < count; i++) {
				aux = aux.getNext();
			}
			
			aux.setNext(head);
		}
		count++;
		return true;
	}
	
	//Procura o soldado indicado pelo usuário e o coloca como head da lista.
	public boolean search(String soldierName) {
		Node aux = head;
		int pos = 0;
		
		while(!aux.getSoldierName().equalsIgnoreCase(soldierName)) {
			aux = aux.getNext();
			pos++;
			
			if(pos > count) {
				return false;
			}
		}
		
		head = aux;
		return true;
	}
	
	//Remove o soldado baseado no número aleatório sorteado e 
	//coloca o próximo soldado da lista como head.
	public boolean remove(int n) {
		if(!isEmpty()) {
			Node p1 = head, p2 = null;
			
			for(int i = 0; i < n; i++) {
				p2 = p1;
				p1 = p1.getNext();
			}
			
			head = p1.getNext();
			p2.setNext(p1.getNext());
			
			System.out.println("Número sorteado: " + n + ", soldado: " + p1.getSoldierName());
			
			count--;
			return true;
		} else {
			return false;
		}
	}
	
	//Formatação para exibir os elementos da lista.
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		Node aux = head;
		sb.append(String.format("\n%-20s %-5s\n", "Soldados", "Código"));
		sb.append("---------------------------\n");		
		do {
			sb.append(String.format("%-20s %-5s\n", aux.getSoldierName(), aux.getSoldierCode()));
			aux = aux.getNext();
		} while(aux != head);
		
		return sb.toString();
	}
}
