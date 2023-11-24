public class CircleLinkedList {
    // Circle linked list class

    private Node head, tail;
    private int count;
    // lineBegin and lineEnd are used select an excerpt from the text
    private int lineBegin = -1, lineEnd = -1;

    // Constructor
    public CircleLinkedList() {
        head = tail = null;
        count = 0;
    }

    // Getters and setters
    public int getCount() {
        return count;
    }

    public Node getHead() {
        return head;
    }

    public int getLineBegin() {
        return lineBegin;
    }

    public void setLineBegin(int lineBegin) {
        this.lineBegin = lineBegin;
    }

    public int getLineEnd() {
        return lineEnd;
    }

    public void setLineEnd(int lineEnd) {
        this.lineEnd = lineEnd;
    }

    // Verifies if the linked list is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Verifies if the linked list is full
    public boolean isFull() {
        Node aux = new Node();
        return aux == null;
    }

    // Insert a new line in the end of the linked list
    public boolean insertLine(String line) {
        if(!isFull()) {
            Node aux = new Node(line, null);
            if(isEmpty()) {
                head = tail = aux;
                aux.setNext(aux);
            } else {
                tail.setNext(aux);
                tail = aux;
                tail.setNext(head);
            }

            count++;
            return true;
        }
        return false;
    }

    // Insert a new line at the "pos" position
    public boolean insertPos(int pos, String line) {
        if(!isFull()) {
            Node p1 = head;
            Node p2 = null;

            for(int i = 1; i < pos - 1; i++) {
                p2 = p1;
                p1 = p1.getNext();
            }

            Node aux = new Node(line, null);
            if(p2 == null) {
                aux.setNext(p1);
                head = aux;
                tail.setNext(aux);
            } else if(p1 == tail) {
                tail.setNext(aux);
                tail = aux;
                tail.setNext(head);
            } else {
                p2.setNext(aux);
                aux.setNext(p1);
            }

            count++;
            return true;
        }
        return false;
    }

    // Search for a line in the linked list based on the line number
    public String searchLine(int line) {
        Node aux = head;
        for(int i = 1; i < line; i++) {
            aux = aux.getNext();
        }

        return aux.getLine();
    }

    // Search all occurrences of an element in the linked list (max one word to find all occurrences)
    public boolean searchElement(String element) {
        boolean flag = false;
        Node aux = head;

        for(int i = 1; i < count; i++) {
            if(aux.getLine().contains(element)) {
                System.out.println(aux.getLine());
                flag = true;
            }
            aux = aux.getNext();
        }

        if(!flag) return false;
        else return true;
    }

    // Replace all occurrences of an element with another element (max one word to replace and be replaced)
    public boolean replaceElement(String element, String elementReplace) {
        boolean flag = false;
        Node aux = head;

        for(int i = 1; i < count; i++) {
            if(aux.getLine().contains(element)) {
                String line = aux.getLine();
                line = line.replace(element, elementReplace);
                aux.setLine(line);

                flag = true;
            }
            aux = aux.getNext();
        }

        if(!flag) return false;
        else return true;
    }

    // Delete excerpt (previously selected) from the linked list
    public boolean deleteExcerpt() {
        if(!isFull() && !isEmpty()) {
            Node auxBegin = head, auxEnd = head;

            for(int i = 1; i < lineBegin - 1; i++) {
                auxBegin = auxBegin.getNext();
            }

            auxEnd = auxBegin.getNext();
            for(int i = lineBegin; i < lineEnd + 1; i++) {
                auxEnd = auxEnd.getNext();
            }

            auxBegin.setNext(auxEnd);

            count = count - (lineEnd - lineBegin + 1);
            return true;
        }
        return false;
    }

    // Delete line from the linked list based on the line number
    public boolean deleteLine(int line) {
        if(!isFull() && !isEmpty()) {
            if(count == 1) {
                head = tail = null;
            } else {
                Node p1 = head;
                Node p2 = null;

                for(int i = 1; i < line; i++) {
                    p2 = p1;
                    p1 = p1.getNext();
                }

                if(p1 == head) {
                    tail.setNext(head.getNext());
                    head = head.getNext();
                } else {
                    p2.setNext(p1.getNext());
                }
            }

            count--;
            return true;
        }
        return false;
    }

    // Delete from the selected line to the end of the linked list
    public boolean deleteEnd(int line) {
        if(!isFull() && !isEmpty()) {
            Node aux = head;
            for(int i = 1; i < line; i++) {
                aux = aux.getNext();
            }

            aux.setNext(head);
            tail = aux;

            count = line;
            return true;
        }
        return false;
    }

    // Delete from beginning of the linked list to the selected line
    public boolean deleteBegin(int line) {
        if(!isFull() && !isEmpty()) {
            Node aux = head;
            for(int i = 1; i < line; i++) {
                aux = aux.getNext();
            }

            tail.setNext(aux);
            head = aux;

            count = count - line + 1;
            return true;
        }
        return false;
    }

    // Print file from "firstLine" to "lastLine"
    public void printFile(int firstLine, int lastLine, boolean number) {
        Node aux = head;

        for(int i = 1; i < firstLine; i++) {
            aux = aux.getNext();
        }

        if(number) {
            for (int i = firstLine; i <= lastLine; i++) {
                System.out.printf("%-3d", i);
                System.out.println(aux.getLine());
                aux = aux.getNext();
            }
        } else {
            for (int i = firstLine; i <= lastLine; i++) {
                System.out.println(aux.getLine());
                aux = aux.getNext();
            }
        }
    }
}
