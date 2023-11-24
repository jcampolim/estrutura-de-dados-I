package AtivKishimoto;

//Júlia Campolim de Oste - 42201691
//João Pedro Zavanela Andreu - 42246271

public class Node {

    private int data;

    private Node next;

    public Node() { this(0, null); }

    public Node(int data) { this(data, null); }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public int getData() { return data; }

    public void setData(int data) { this.data = data; }

    public Node getNext() { return next; }

    public void setNext(Node next) { this.next = next; }

    @Override
    public String toString() {
        return "data: " + data
                + ", next: " + (next != null ? next.getData() : "null");
    }
}
