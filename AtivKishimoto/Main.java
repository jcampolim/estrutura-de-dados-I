package AtivKishimoto;

//Júlia Campolim de Oste - 42201691
//João Pedro Zavanela Andreu - 42246271

import java.sql.SQLOutput;

public class Main {

    //Q10
    public static LinkedList merge(LinkedList listA, LinkedList listB) {
        LinkedList listC = new LinkedList();

        for(int i = 1; i <= listA.count(); i++) {
            listC.insertAsc(listA.getNodeAt(i).getData());
        }

        for(int i = 1; i <= listB.count(); i++) {
            listC.insertAsc(listB.getNodeAt(i).getData());
        }
        return listC;
    }

    //Q11
    public static LinkedList mergeNoDup(LinkedList listA, LinkedList listB) {
        LinkedList listC = new LinkedList();

        for(int i = 1; i <= listA.count(); i++) {
            listC.insertAscNoDup(listA.getNodeAt(i).getData());
        }

        for(int i = 1; i <= listB.count(); i++) {
            listC.insertAscNoDup(listB.getNodeAt(i).getData());
        }
        return listC;
    }

    //Q12
    public static boolean areEqual(LinkedList listA, LinkedList listB) {
        if(listA.count() != listB.count()) {
            return false;
        } else {
            for(int i = 1; i <= listA.count(); i++) {
                if(listA.getNodeAt(i).getData() != listB.getNodeAt(i).getData()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        //Q8 - o remove funcionou como deveria funcionar
        list.insertAsc(3);
        list.insertAsc(2);
        list.insertAsc(1);
        list.remove(list.getNode(2)); // remove(): true
        list.remove(list.getNode(99)); // remove(): false

        System.out.println(list);
        list.remove(list.getNode(3));
        System.out.println(list);
    }
}
