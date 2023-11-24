package ListaEncadeada;

public class Node {
	
	private int dado;
	private Node prox;
	
	public Node(int dado, Node prox) {
		this.dado = dado;
		this.prox = prox;
	}
	
	public Node() {
		this(0, null);
	}
	
	public void setDado(int dado) {
		this.dado = dado;
	}
	
	public int getDado() {
		return dado;
	}
	
	public void setProx(Node prox) {
		this.prox = prox;
	}
	
	public Node getProx() {
		return prox;
	}

	public void setNext(Node aux) {
		// TODO Auto-generated method stub
		
	}
}
