import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int[] arr = new int[input];
        for (int i = 0; i < input; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(getHeight(arr));

    }
    public static int getHeight(int[] array) {
        int height = 0;
        for (int i = 0; i < array.length; i++) {
            int edge = 0;
            int parent = array[i];
            while (parent != -1) {
                parent = array[parent];
                edge++;
            }
            if (edge > height) {
                height = edge;
            }
        }
        return height + 1;
    }
}