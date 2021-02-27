import java.util.Map;

class MapFunctions {

    public static void calcTheSamePairs(Map<String, String> map1, Map<String, String> map2) {
        int count = 0;
        String[] k1 = map1.keySet().toArray(new String[0]);
        String[] k2 = map2.keySet().toArray(new String[0]);
        for (String key1: k1) {
            for (String key2: k2) {
                if (key1.equals(key2) && map1.get(key1).equals(map2.get(key2))) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}