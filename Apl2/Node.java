public class Node {
    // Node class with a string representing a line of the file and a pointer to the next Node

    private String line;
    private Node next;

    // Constructors
    public Node() {
        this("", null);
    }

    public Node(String line, Node next) {
        this.line = line;
        this.next = next;
    }

    // Getters and setters
    public void setLine(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }
}
