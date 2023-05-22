class Node {
    int key;
    int height;
    Node left;
    Node right;

    Node(int key) {
        this.key = key;
        this.height = 1;
    }
}

public class AVLTree {
    private Node root;

    private int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    private int balanceFactor(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private Node insert(Node node, int key) {
        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = balanceFactor(node);

        if (balance > 1 && key < node.left.key)
            return rotateRight(node);

        if (balance < -1 && key > node.right.key)
            return rotateLeft(node);

        if (balance > 1 && key > node.left.key) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    public void printTree() {
        preOrder(root);
        System.out.println();
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        System.out.println("AVL tree:");
        tree.printTree();
    }
}
