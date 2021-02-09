import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int input = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < input; i++) {
            String[] arr = scanner.nextLine().split(" ");
            switch (arr[0]) {
                case "split":
                    str = split(str, Integer.parseInt(arr[1]));
                    break;
                case "reverse":
                    str = reverse(str);
                    break;
                default:
                    break;

            }
        }
        System.out.println(str);
    }
    public static String split(String s, int index) {
        String first = s.substring(0, index);
        String last = s.substring(index);
        s = last + first;
        return s;
    }
    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        s = sb.toString();
        return s;
    }
}