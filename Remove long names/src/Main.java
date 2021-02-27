import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MapFunctions {

    public static void removeLongNames(Map<String, String> map) {
        String[] k = map.keySet().toArray(new String[0]);
        String[] v = map.values().toArray(new String[0]);
        for (String key : k) {
            if (key.length() > 7) {
                map.remove(key);
            } else {
                if (map.get(key).length() > 7) {
                    map.remove(key);
                }
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

        MapFunctions.removeLongNames(map);

        System.out.println(map.size());
    }
}