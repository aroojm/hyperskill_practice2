import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String regex = "(?i)password\\s*:?\\s*[0-9a-zA-Z]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        String regex2 = "(?i)password\\s*:?\\s*";
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2;
        int i, j;

        if (matcher.find()) {
            String temp = matcher.group();
            matcher2 = pattern2.matcher(temp);
            matcher2.find();
            i = matcher2.end();
            // System.out.println(temp);
            System.out.println(temp.substring(i));
            matcher2.reset();
            while (matcher.find()) {
                temp = matcher.group();
                matcher2 = pattern2.matcher(temp);
                matcher2.find();
                j = matcher2.end();
                // System.out.println(temp);
                System.out.println(temp.substring(j));
                matcher2.reset();
            }
        } else {
            System.out.println("No passwords found.");

        }

    }

}