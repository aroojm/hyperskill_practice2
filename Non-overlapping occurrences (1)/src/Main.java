import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();
        String text = scanner.nextLine();
        List l1 = KMPSearch(text, pattern);
        if (pattern.length() == 0) {
            System.out.println(0);
        } else {
            method(l1, pattern);
        }
    }
    public static void method(List l1, String pattern) {
        if (l1.size() == 0) {
            System.out.println(0);
        } else {
            List l2 = new ArrayList();
            int current = (int) l1.get(0);
            l2.add(current);
            for (int i = 1; i < l1.size(); i++) {
                int next = (int) l1.get(i);
                if (next - current >= pattern.length()) {
                    current = next;
                    l2.add(current);
                }
            }
            System.out.println(l2.size());
            for (int i = 0; i < l2.size(); i++) {
                System.out.print(l2.get(i) + " ");
            }
        }
    }
    public static int[] prefixFunction(String str) {
        int[] prefixFunc = new int[str.length()];
        for (int i = 1; i < str.length(); i++) {
            int j = prefixFunc[i - 1];
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = prefixFunc[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                j += 1;
            }
            prefixFunc[i] = j;
        }
        return prefixFunc;
    }
    public static List<Integer> KMPSearch(String text, String pattern) {
        int[] prefixFunc = prefixFunction(pattern);
        ArrayList<Integer> occurrences = new ArrayList<Integer>();
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = prefixFunc[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j += 1;
            }
            if (j == pattern.length()) {
                occurrences.add(i - j + 1);
                j = prefixFunc[j - 1];
            }
        }
        return occurrences;
    }
}