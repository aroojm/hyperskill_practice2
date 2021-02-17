import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        Integer[] parent = new Integer[input];
        Integer[] child = new Integer[input];
        for (int i = 0; i < input; i++) {
            parent[i] = scanner.nextInt();
            child[i] = scanner.nextInt();
        }
        List<Integer> list =  Arrays.asList(parent);
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < input; i++) {
            if (!(list.contains(child[i]))) {
                output.add(child[i]);
            }
        }
        System.out.println(output.size());
        for (int i = 0; i < output.size(); i++) {
            System.out.print(output.get(i) + " ");
        }
    }
}