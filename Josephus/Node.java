package Josephus;

//Erika Borges Piaui - 32284683
//João Pedro Zavanela Andreu - 42246271
//Júlia Campolim de Oste - 42201691

//Cria a classe node, que recebe o soldado e o endereço do próximo 
//elemento da lista.
public class Node {
	
	private Soldier soldier;
	private Node next;
	public Node(String name, int code, Node next) {
		this.soldier = new Soldier(name, code);
		this.next = next;
	}
	
	public Node() {
		this(null, 0, null);
	}
	
	public String getSoldierName() {
		return soldier.getName();
	}
	
	public int getSoldierCode() {
		return soldier.getCode();
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getNext() {
		return next;
	}
}
