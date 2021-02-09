import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static class TableEntry<T> {
        private final int key;
        private final T value;

        public TableEntry(int key, T value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }
    }

    private static class HashTable<T> {
        private int size;
        private TableEntry[] table;

        public HashTable(int size) {
            this.size = size;
            table = new TableEntry[size];
        }

        public boolean put(int key, T value) {
            int hash = key % size;
            if (findKey(key) == -1) {
                table[hash] = new TableEntry(key, value);
            } else {
                table[hash] = new TableEntry(key, table[hash].getValue() + " " + value);
            }
            return true;
        }

        public T get(int key) {
            int hash = key % size;
            if (findKey(key) == -1) {
                return null;
            }
            return (T) table[hash].getValue();
        }

        public TableEntry[] entrySet() {
            return table;
        }



        private int findKey(int key) {
            int hash = key % size;
            if (table[hash] == null) {
                return -1;
            } else {
                return hash;
            }

        }

        private void rehash() {
            // put your code here
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        scanner.nextLine();
        HashTable<String> t = new HashTable<>(input);
        for (int i = 0; i < input; i++) {
            String str = scanner.nextLine();
            String[] arr = str.split(" ");
            int k = Integer.parseInt(arr[0]);
            t.put(k, arr[1]);
        }
        for (int i = 0; i < input; i++) {
            if (t.entrySet()[i] != null) {
                System.out.println(t.entrySet()[i].getKey() +": " + t.entrySet()[i].getValue());
            }
        }

    }
}