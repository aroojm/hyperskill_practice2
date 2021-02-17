import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        for (int i = 0; i < input; i++) {
            bst.insert(scanner.nextInt(), 0);
        }
        System.out.println(bst.maxHeight());
    }
}
class BinarySearchTree {
    Node root;
    public BinarySearchTree() {
        root = null;
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

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public int maxHeight() {
        return maxHeight(root);

    }
    int maxHeight(Node node) {
        if (node == null) {
            return -1;
        } else {
            int lHeight = maxHeight(node.left);
            int rHeight = maxHeight(node.right);
            return (Math.max(lHeight, rHeight) + 1);
        }
    }

}
class Node {
    int key;
    int value;
    Node left;
    Node right;
    Node parent;

    public Node(int key, int value, Node parent) {
        this.key = key;
        this.value = value;
        this.parent = parent;
    }
}