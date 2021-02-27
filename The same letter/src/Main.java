import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MapFunctions {

    public static void printWithSameLetter(Map<String, String> map) {
        String[] k = map.keySet().toArray(new String[0]);
        for (String key: k) {
            if (map.get(key).charAt(0) == key.charAt(0)) {
                System.out.println(key + " " + map.get(key));
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] pair = s.split(" ");
            map.put(pair[0], pair[1]);
        }

        MapFunctions.printWithSameLetter(map);
    }
}