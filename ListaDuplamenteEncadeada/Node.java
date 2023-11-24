package ListaDuplamenteEncadeada;

public class Node {
	
	private int dado;
	private Node next;
	
	//lista duplamente encadeada
	private Node previous;
	
	public Node(int dado, Node next, Node previous) {
		this.dado = dado;
		this.next = next;
		this.previous = previous;
	}

	public Node() {
		this.dado = 0;
		next = previous = null;
	}
	
	public int getDado() {
		return dado;
	}
	
	public void setDado(int dado) {
		this.dado = dado;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getPrevious() {
		return previous;
	}
	
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
}
