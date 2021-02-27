import java.util.ArrayList;
import java.util.LinkedList;

class ListOperations {
    public static void mergeLists(LinkedList<String> linkedList, ArrayList<String> arrayList) {
        int len = arrayList.size();
        for (int i = 0; i < len; i++) {
            linkedList.addLast(arrayList.get(i));
        }
        int size = linkedList.size();
        System.out.println("The new size of LinkedList is " + size);


    }
}