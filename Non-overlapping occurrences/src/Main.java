import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();
        String text = scanner.nextLine();
        countNonOverlapOccurrences(text, pattern);
    }

    public static void countNonOverlapOccurrences(String text, String pattern) {
        if (pattern.length() == 0) {
            System.out.println(1);
            System.out.println(0);
            return;
        }
        if (text.length() < pattern.length()) {
            System.out.println(0);
            return;
        }
        int count = 0;
        List index = new ArrayList();

        for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
            boolean patternIsFound = true;

            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    patternIsFound = false;
                    break;
                }
            }
            if (patternIsFound) {
                count++;
                index.add(i);
                i = i + pattern.length() - 1;
            }
        }
        if (count == 0) {
            System.out.println(0);
        } else {
            System.out.println(count);
            for (int i = 0; i < index.size(); i++) {
                System.out.print(index.get(i) + " ");
            }
        }
    }

}