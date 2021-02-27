import java.util.ArrayList;
import java.util.LinkedList;

class ListOperations {
    public static void changeHeadsAndTails(LinkedList<String> linkedList, ArrayList<String> arrayList) {
        String listFirst = linkedList.getFirst();
        String listLast = linkedList.getLast();
        String arrFirst = arrayList.get(0);
        String arrLast = arrayList.get(arrayList.size() - 1);

        linkedList.set(0, arrFirst);
        linkedList.removeLast();
        linkedList.addLast(arrLast);

        arrayList.set(0, listFirst);
        arrayList.set(arrayList.size() - 1, listLast);
    }
}