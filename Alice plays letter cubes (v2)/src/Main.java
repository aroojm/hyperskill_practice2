import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(countAll(str) + 1);
    }
    public static int countAll(String str) {
        int count = 0;
        int len = str.length();
        for (int i = len; i >= 0 ; i--) {
            count += newSubsCount(str.substring(i, len));
        }
        return count;
    }
    public static int newSubsCount(String str) {
        int[] prefixFunc = new int[str.length()];
        int count = 0;
        for (int i = 1; i < str.length(); i++) {
            int j = prefixFunc[i - 1];
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = prefixFunc[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                j += 1;
            }
            prefixFunc[i] = j;
            count = Math.max(count, j);
        }
        return str.length() - count;
    }
}