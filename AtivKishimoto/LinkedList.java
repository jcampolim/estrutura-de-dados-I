package AtivKishimoto;

//Júlia Campolim de Oste - 42201691
//João Pedro Zavanela Andreu - 42246271

public class LinkedList {

    private Node head;

    private int count;

    public LinkedList() {
        head = null;
        count = 0;
    }

    public int count() {
        return count;
    }

    //Q1
    public void insertAsc(int value) {
        if(!isFull()) {
            Node aux = new Node(value, null);

            if(isEmpty()) {
                head = aux;
            } else {
                Node p1 = head;
                Node p2 = null;

                while(p1.getData() <= value && p1.getNext() != null) {
                    p2 = p1;
                    p1 = p1.getNext();
                }

                if(p1 == head && p1.getData() > value) {
                    aux.setNext(head);
                    head = aux;
                } else if(value < p1.getData()) {
                    aux.setNext(p1);
                    p2.setNext(aux);
                } else {
                    p1.setNext(aux);
                }
            }
            count++;
        }
    }

    //Q2
    public boolean insertAscNoDup(int value) {
        if(!isFull()) {
            Node aux = head;

            while(aux != null) {
                if(aux.getData() == value) {
                    return false;
                }
                aux = aux.getNext();
            }

            insertAsc(value);
            return true;
        }
        return false;
    }

    //Q3
    public void insertDesc(int value) {
        if(!isFull()) {
            Node aux = new Node(value, null);

            if(isEmpty()) {
                head = aux;
            } else {
                Node p1 = head;
                Node p2 = null;

                while(p1.getData() > value && p1.getNext() != null) {
                    p2 = p1;
                    p1 = p1.getNext();
                }

                if(p1 == head && p1.getData() < value) {
                    aux.setNext(head);
                    head = aux;
                } else if(value > p1.getData()) {
                    aux.setNext(p1);
                    p2.setNext(aux);
                } else {
                    p1.setNext(aux);
                }
            }
            count++;
        }
    }

    //Q4
    public boolean insertDescNoDup(int value) {
        if(!isFull()) {
            Node aux = head;

            while(aux != null) {
                if(aux.getData() == value) {
                    return false;
                }
                aux = aux.getNext();
            }

            insertDesc(value);
            return true;
        }
        return false;
    }

    //Q5
    public int removeDup() {
        int qtde = 0;

        if(!isEmpty()) {
            Node aux = head;

            while(aux.getNext() != null) {
                if(aux.getData() == aux.getNext().getData()) {
                    aux.setNext(aux.getNext().getNext());
                    count--;
                    qtde++;
                }
                aux = aux.getNext();
            }
        }

        return qtde;
    }

    //Q6
    public Node getNode(int value) {
        Node aux = head;

        while(aux != null) {
            if(value == aux.getData()) {
                return aux;
            }
            aux = aux.getNext();
        }

        return null;
    }

    //Q7
    public boolean remove(Node node) {
        if(!isEmpty() && node != null) {
            Node aux = getNodeAt(0);

            while(aux.getNext() != node) {
                aux = aux.getNext();
            }

            aux.setNext(node.getNext());
            count--;
            return true;
        }
        return false;
    }

    //Q9
    public Node getNodeAt(int position) {
        Node aux = head;

        for(int i = 1; i < position; i++) {
            aux = aux.getNext();
        }
        return aux;
    }

    public boolean isFull() {
        Node aux = new Node();
        return aux == null;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        if (head == null)
            return "empty";
        StringBuilder sb = new StringBuilder();
        sb.append("[" + count + "] ");
        Node current = head;
        while (current != null) {
            sb.append(current.getData()).append(" -> ");
            current = current.getNext();
        }
        sb.append("null.");
        return sb.toString();
    }
}
