import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String original = scanner.nextLine();
        int input = scanner.nextInt();
        String[] arr = new String[input];
        scanner.nextLine();
        arr = scanner.nextLine().split(" ");
        for (int i = 0; i < input; i++) {
            String temp = arr[i] + original;
            System.out.print(function(original, temp) + " ");
        }
    }
    public static int function(String oldStr, String newStr) {
        int count = 0;
        for (int i = 0; i < newStr.length(); i++) {
            for (int j = i + 1; j <= newStr.length(); j++) {
                String tem = newStr.substring(i, j);
                if (! oldStr.contains(tem)) {
                    count++;
                }
            }
        }
        return count;
    }
}