package ListaDuplamenteEncadeada;

public class List {

	private Node head, tail;

	public List() {
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
		return false;
	}

	public boolean insertHead(int dado) {
		if(!isFull()) {
			Node aux = new Node(dado, null, null);
			if(isEmpty()) {
				head = tail = aux;
			} else {
				aux.setNext(head);
				head = aux;
			}
			return true;
		}
		return false;
	}

	public boolean insertPos(int dado, int pos) {
		if(!isFull()) {
			Node p1 = head;
			int cont = 0;

			while(cont < pos && p1.getNext() != null) {
				cont++;
				p1 = p1.getNext();
			}

			if(cont > pos) {
				return false;
			}

			if(p1 == head) {
				insertHead(dado);
			} else if(p1 == tail) {
				insertTail(dado);
			} else {
				Node aux = new Node(dado, p1, p1.getPrevious());
				p1.getPrevious().setNext(aux);
				p1.setPrevious(aux);
			}
			return true;
		}
		return false;
	}

	public boolean insertTail(int dado) {
		if(!isFull()) {
			Node aux = new Node(dado, null, null);
			if(isEmpty()) {
				head = tail = aux;
			} else {
				tail.setNext(aux);
				aux.setPrevious(tail);
				tail = aux;
			}
			return true;
		}
		return false;
	}

	public boolean removeHead() {
		if(!isEmpty()) {
			head = head.getNext();
			head.setPrevious(null);

			return true;
		}
		return false;
	}

	public boolean removePos(int pos) {
		if(!isEmpty()) {
			Node p1 = head, p2 = null;
			int cont = 0;

			while(cont < pos && p1.getNext() != null) {
				cont++;
				p2 = p1;
				p1 = p1.getNext();
			}

			if(cont > pos) {
				return false;
			}

			if(p1 == head) {
				removeHead();
			} else if(p1.getNext() == null && cont == pos) {
				removeTail();
			} else {
				p2.setNext(p1.getNext());
				p1.getNext().setPrevious(p2);
			}
			return true;
		}
		return false;
	}

	public boolean removeTail() {
		if(!isEmpty()) {
			tail = tail.getPrevious();
			tail.setNext(null);
			return true;
		}
		return false;
	}

	public void printList() {
		Node aux = head;
		System.out.print(aux.getDado() + " ");
		while(aux.getNext() != null) {
			aux = aux.getNext();
			System.out.print(aux.getDado()  + " ");
		}
	}
}
