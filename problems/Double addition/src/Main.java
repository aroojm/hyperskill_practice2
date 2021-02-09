import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.addFirst(scanner.nextInt());
        for (int i = 1; i < input; i++) {
            int num = scanner.nextInt();
            int diff1 = Math.abs(num - dll.head.value);
            int diff2 = Math.abs(num - dll.tail.value);
            if (diff1 < diff2) {
                dll.addFirst(num);
            } else {
                dll.addLast(num);
            }
        }
        System.out.println(dll);
    }

}
class DoubleLinkedList {
    Node head;
    Node tail;
    int size;

    class Node {
        int value;
        Node prev;
        Node next;

        Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public DoubleLinkedList() {
        size = 0;
    }
    public void addFirst(int num) {
        Node temp = new Node(num, head, null);
        if (size == 0) {
            head = tail = temp;
        } else {
            head.prev = temp;
            head = temp;
        }
        size++;
    }
    void addLast(int num) {
        Node temp = new Node(num, null, tail);
        if (size == 0) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }
    public String toString() {
        Node temp = head;
        StringBuilder result = new StringBuilder();
        while (temp != null) {
            result.append(temp.value).append(" ");
            temp = temp.next;
        }
        return result.toString();
    }
}