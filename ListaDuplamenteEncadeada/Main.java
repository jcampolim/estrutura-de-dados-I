package ListaDuplamenteEncadeada;

public class Main {

	public static void main(String[] args) {

		List l = new List();
		l.insertTail(7);
		l.insertTail(3);
		l.insertTail(1);
		l.insertPos(2, 0);
		l.insertPos(5, 4);

		l.printList();
		System.out.println();

		l.removeTail();
		l.printList();
	}

}
