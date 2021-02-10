import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += logValue(arr[i]);
        }
        System.out.println(count);
    }
    public static int logValue(String str) {
        switch (str) {
            case "severe":
                return 1000;
            case "warning":
                return 900;
            case "info":
                return 800;
            case "config":
                return 700;
            case "fine":
                return 500;
            case "finer":
                return 400;
            case "finest":
                return 300;
            default:
                return 0;
        }
    }
}