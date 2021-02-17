import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);
        List ls = new ArrayList();
        int input = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < input; i++) {
            String[] array = scanner.nextLine().split(" ");
            String op = array[0];
            int k = Integer.parseInt(array[1]);
            switch(op) {
                case "+":
                    bst.insert(k, k);
                    break;
                case "?":
                    Node n = bst.search(k);
                    if (n == null) {
                        ls.add("no");
                    } else {
                        ls.add(bst.Depth(n));
                    }
                    break;
                default:
                    break;
            }
        }
        for (int i = 0; i < ls.size(); i++) {
            System.out.println(ls.get(i));
        }
    }
}
class BinarySearchTree {
    Node root;
    public BinarySearchTree() {
        root = null;
    }

    Node search(Node t, int key) {
        if (t == null || t.key == key)
            return t;
        if (key < t.key)
            return search(t.left, key);
        else
            return search(t.right, key);
    }

    public Node search(int key) {
        return search(root, key);
    }

    Node insert(Node t, Node p, int key, int value) {
        if (t == null) {
            t = new Node(key, value, p);
        } else {
            if (key < t.key)
                t.left = insert(t.left, t, key, value);
            else
                t.right = insert(t.right, t, key, value);
        }
        return t;
    }

    public void insert(int key, int value) {
        root = insert(root, null, key, value);
    }

    void replace(Node a, Node b) {
        if (a.parent == null)
            root = b;
        else if (a == a.parent.left)
            a.parent.left = b;
        else
            a.parent.right = b;
        if (b != null)
            b.parent = a.parent;
    }

    void remove(Node t, int key) {
        if (t == null)
            return;
        if (key < t.key)
            remove(t.left, key);
        else if (key > t.key)
            remove(t.right, key);
        else if (t.left != null && t.right != null) {
            Node m = t.right;
            while (m.left != null)
                m = m.left;
            t.key = m.key;
            t.value = m.value;
            replace(m, m.right);
        } else if (t.left != null) {
            replace(t, t.left);
        } else if (t.right != null) {
            replace(t, t.right);
        } else {
            replace(t, null);
        }
    }

    public void remove(int key) {
        remove(root, key);
    }

    public int Depth(Node node) {
        Depth(root, 0);
        return node.depth;
    }
    void Depth(Node node, int depth) {
        if (node != null) {
            node.depth = depth;
            Depth(node.left, depth + 1);
            Depth(node.right, depth + 1);
        }
    }
}
class Node {
    int key;
    int value;
    Node left;
    Node right;
    Node parent;
    public int depth;

    public Node(int key, int value, Node parent) {
        this.key = key;
        this.value = value;
        this.parent = parent;
    }
}