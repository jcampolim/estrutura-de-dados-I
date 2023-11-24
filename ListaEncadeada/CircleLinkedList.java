package ListaEncadeada;

public class CircleLinkedList {
	
	private Node head;
	private Node tail;
	private int count;
	
	public CircleLinkedList() {
		head = tail = null;
		count = 0;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public boolean isFull() {
		Node aux = new Node(); 
		if(aux == null) return true;
		aux = null;
		return false;
	}
	
	public boolean insertHead(int data) {
		if(isFull()) return false;
		Node aux = new Node(data, null);
		if(isEmpty()) {
			head = tail = aux;
			aux.setProx(aux);		
		} else {
			aux.setProx(head);
			head = aux;
			tail.setProx(head);
		}
		count++;
		return true;
	}

	public boolean insertPos(int data, int pos) {
		if(!isFull()) {
			Node p1 = head, p2 = null;
			int cont = 0;

			while(p1 != tail && cont < pos) {
				cont++;
				p2 = p1;
				p1 = p1.getProx();
			}

			if(cont == pos) {
				if(p1 == head) {
					insertHead(data);
				} else if(p1 == tail) {
					insertTail(data);
				} else {
					System.out.println("a");
					Node aux = new Node(data, p1);
					p2.setNext(aux);
				}
				return true;
			}
		}
		return false;
	}
	
	public boolean insertTail(int data) {
		if(isFull()) return false;
		Node aux = new Node(data, null);
		if(isEmpty()) {
			head = tail = aux;
			aux.setProx(aux);		
		} else {
			tail.setProx(aux);
			tail = aux;
			tail.setProx(head);
		}
		count++;
		return true;
	}
	
	public boolean removeHead() {
		if(!isEmpty()) {
			head = head.getProx();
			tail.setProx(head);
		}
		return false;
	}

	public boolean removePos(int pos) {
		if(!isEmpty()) {
			Node p1 = head, p2 = null;
			int cont = 0;

			while(p1 != tail && cont < pos) {
				cont++;
				p2 = p1;
				p1 = p1.getProx();
			}

			if(cont == pos) {
				if(p1 == head) {
					removeHead();
				} else if(p1 == tail) {
					removeTail();
				} else {
					p2.setProx(p1.getProx());
				}
				return true;
			}
		}
		return false;
	}

	public boolean removeTail() {
		if(!isEmpty()) {
			Node p1 = head;
			while(p1.getProx() != tail) {
				p1 = p1.getProx();
			}

			tail = p1;
			tail.setProx(head);
		}
		return false;
	}

	public void printList() {
		Node aux = head;
		System.out.print(aux.getDado() + " ");
		while(aux.getProx() != head) {
			aux = aux.getProx();
			System.out.print(aux.getDado()  + " ");
		}
	}
}
