package ListaEncadeada;

public class LinkedList {
	
	private Node head, tail;
	
	public LinkedList() {
		head = tail = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public boolean isFull() {
		Node aux = new Node();
		if(aux == null) {
			return true;
		}
		aux = null;
		return false;
	}
	
	public boolean insertHead(int dado) {
		if(!isFull()) {
			Node aux = new Node(dado, null);
			if(isEmpty()) {
				head = tail = aux;
			} else {
				aux.setProx(head);
				head = aux;
			}
			return true;
		}
		return false;
	}

	public boolean insertPos(int dado, int pos) {
		if(!isFull()) {
			Node p1 = head;
			int cont = 1;

			while(cont < pos && p1.getProx() != null) {
				cont++;
				p1 = p1.getProx();
			}

			if(cont == pos) {
				Node aux = new Node(dado, p1.getProx());
				p1.setProx(aux);
				if(p1 == tail) {
					tail = aux;
				}
				return true;
			}

			return false;
		}
		return false;
	}

	public boolean insertTail(int dado) {
		if(!isFull()) {
			Node aux = new Node(dado, null);
			if(isEmpty()) {
				head = tail = aux;
			} else {
				tail.setProx(aux);
				tail = aux;
			}
			return true;
		}
		return false;
	}
	
	public boolean removeHead() {
		if(!isEmpty()) {
			Node aux = head;
			head = head.getProx();
			aux = null;

			return true;
		}
		return false;
	}

	public boolean removePos(int pos) {
		if(!isEmpty()) {
			Node p1 = head, p2 = null;
			int cont = 0;

			while(cont < pos && p1.getProx() != null) {
				cont++;
				p2 = p1;
				p1 = p1.getProx();
			}

			if(cont == pos) {
				p2.setProx(p1.getProx());
				if(p1 == tail) {
					tail = p2;
				}
				return true;
			}

			return false;
		}
		return false;
	}

	public boolean removeTail() {
		if(!isEmpty()) {
			Node p1 = head, p2 = null;
			while(p1.getProx() != null) {
				p2 = p1;
				p1 = p1.getProx();
			}

			p2.setProx(null);
			tail = p2;
			return true;
		}
		return false;
	}

	public void printList() {
		Node aux = head;
		System.out.print(aux.getDado() + " ");
		while(aux.getProx() != null) {
			aux = aux.getProx();
			System.out.print(aux.getDado()  + " ");
		}
	}
}
