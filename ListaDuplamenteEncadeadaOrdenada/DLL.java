package ListaDuplamenteEncadeadaOrdenada;

public class DLL {

	private int count;
	private Node head;
	
	public DLL() {
		count = 0;
		head = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public boolean isFull() {
		Node aux = new Node();
		return aux == null;
	}
	
	public boolean insertAscending(int key, String data) {
		if(!isFull()) {
			Node aux = new Node(key, data, null, null);
			
			if(isEmpty()) {
				head = aux;
				head.setLeft(head);
				head.setRight(head);
			} else {
				Node p1 = head;
				Node p2 = null;
				
				while(p1.getRight() != head && p1.getKey() <= key) {
					p2 = p1;
					p1 = p1.getRight();
				}
				
				if(p1 == head) {
					aux.setRight(head);
					aux.setLeft(head.getLeft());
					head = aux;
					p1.getLeft().setRight(aux);
					p1.setLeft(aux);
				} else if(key < p1.getKey()) {
					aux.setRight(p1);
					aux.setLeft(p2);
					p2.setRight(aux);
					p1.setLeft(aux);
				} else {
					aux.setLeft(p1);
					aux.setRight(head);
					p1.setRight(aux);
					head.setLeft(aux);
				}
			}
			
			count++;
			return true;
		}
		
		return false;
	}
	
	public int getCount() {
		return count;
	}
}
