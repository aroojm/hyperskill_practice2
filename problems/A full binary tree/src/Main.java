import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int[] parent = new int[input];
        for (int i = 0; i < input; i++) {
            parent[i] = scanner.nextInt();
            scanner.nextInt();
        }
        if (input == 0) {
            System.out.println("yes");
        } else if (input % 2 != 0) {
            System.out.println("no");
        } else {
            System.out.println(countParents(parent) ? "yes" : "no");
        }

    }
    public static boolean countParents(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            int count = 1;
            for (int j = 0 ; j < array.length ; j++) {
                if (i != j && current == array[j]) {
                    count++;
                }
            }
            if (count != 2) {
                return false;
            }
        }
        return  true;
    }
}
