public class BinarySearchTree {

    private Node root;

    private class Node {
        private int key;
        private Node left;
        private Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    private Node insertRecursive(Node current, int key) {
        if (current == null) {
            return new Node(key);
        }

        if (key < current.key) {
            current.left = insertRecursive(current.left, key);
        } else if (key > current.key) {
            current.right = insertRecursive(current.right, key);
        }

        return current;
    }

    public boolean search(int key) {
        return searchRecursive(root, key);
    }

    private boolean searchRecursive(Node current, int key) {
        if (current == null) {
            return false;
        }

        if (key == current.key) {
            return true;
        }

        if (key < current.key) {
            return searchRecursive(current.left, key);
        } else {
            return searchRecursive(current.right, key);
        }
    }

    public void delete(int key) {
        root = deleteRecursive(root, key);
    }

    private Node deleteRecursive(Node current, int key) {
        if (current == null) {
            return null;
        }

        if (key == current.key) {
            // Case 1: No children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: One child
            if (current.left == null) {
                return current.right;
            }

            if (current.right == null) {
                return current.left;
            }

            // Case 3: Two children
            int smallestKey = findSmallestKey(current.right);
            current.key = smallestKey;
            current.right = deleteRecursive(current.right, smallestKey);

            return current;
        }

        if (key < current.key) {
            current.left = deleteRecursive(current.left, key);
            return current;
        }

        current.right = deleteRecursive(current.right, key);
        return current;
    }

    private int findSmallestKey(Node root) {
        return root.left == null ? root.key : findSmallestKey(root.left);
    }
}
