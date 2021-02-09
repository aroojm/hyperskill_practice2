import java.util.NoSuchElementException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        DoubleLinkedList dll = new DoubleLinkedList();
        scanner.nextLine();
        for (int i = 1; i <= input; i++) {
            String[] arr = scanner.nextLine().split(" ");
            switch (arr[0]) {
                case "addFirst":
                    dll.addFirst(Integer.parseInt(arr[1]));
                    break;
                case "addLast":
                    dll.addLast(Integer.parseInt(arr[1]));
                    break;
                case "removeFirst":
                    dll.removeFirst();
                    break;
                case "removeLast":
                    dll.removeLast();
                    break;
                case "reverse":
                    dll.reverse();
                    break;
                default:
                    break;
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
    public void removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

//        head = head.next;
//        if (head != null) {
//            head.prev = null;
//        } else {
//            tail = null;
//        }

        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }
    public void removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
//        tail = tail.prev;
//        if (tail != null) {
//            tail.next = null;
//        } else {
//            head = null;
//        }

        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            if (tail != null) {
            tail.next = null;}
        }
        size--;
    }
    public void reverse() {
        Node temp = null;
        Node current = head;
        current.prev = current.next;
        current.next = temp;
        tail = current;
        current = current.prev;
        while (current!= null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
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