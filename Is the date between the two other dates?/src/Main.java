import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        LocalDate d1 = LocalDate.parse(arr[0]);
        LocalDate d2 = LocalDate.parse(arr[1]);
        LocalDate d3 = LocalDate.parse(arr[2]);
        boolean check = (d1.isAfter(d2) && d1.isBefore(d3)) ||
                (d1.isAfter(d3) && d1.isBefore(d2));
        if (check) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}