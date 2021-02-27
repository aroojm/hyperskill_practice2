import java.util.ArrayList;
import java.util.LinkedList;

class ListOperations {
    public static void removeTheSame(LinkedList<String> linkedList, ArrayList<String> arrayList) {
        int len = arrayList.size();
        for (int i = len - 1; i >= 0; i--) {
            if (arrayList.get(i).equals(linkedList.get(i))) {
                arrayList.remove(i);
                linkedList.remove(i);
            }
        }
    }
}