package ListaEncadeada;

public class Main {

	public static void main(String[] args) {
		CircleLinkedList l = new CircleLinkedList();
		//l.insertHead(1);

		l.insertPos(10, 0);
		l.insertPos(4, 0);
		l.insertPos(2, 1);
		l.insertPos(8, 2);

		l.printList();
		System.out.println();

		l.removePos(3);

		l.printList();
		System.out.println();

		l.removeTail();

		l.printList();
		System.out.println();
	}

}
