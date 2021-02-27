import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime d1 = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime d2 = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime temp = d1;
        if (d1.isAfter(d2)) {
            d1 = d2;
            d2 = temp;
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        LocalDateTime[] arr = new LocalDateTime[input];
        for (int i = 0; i < input; i++) {
            arr[i] = LocalDateTime.parse(scanner.nextLine());
        }
        int count = 0;

        for (int i = 0; i < input; i++) {
            boolean check = arr[i].isBefore(d2) &&
                    (arr[i].isAfter(d1) || arr[i].isEqual(d1));
            if (check) {
                count++;
            }
        }
        System.out.println(count);
    }
}
