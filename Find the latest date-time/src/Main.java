import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        scanner.nextLine();
        LocalDateTime[] arr = new LocalDateTime[input];
        for (int i = 0; i < input; i++) {
            arr[i] = LocalDateTime.parse(scanner.nextLine());
        }
        LocalDateTime temp = arr[0];
        for (int i = 1; i < input; i++) {
            if (temp.isBefore(arr[i])) {
                temp = arr[i];
            }
        }
        System.out.println(temp);
    }
}