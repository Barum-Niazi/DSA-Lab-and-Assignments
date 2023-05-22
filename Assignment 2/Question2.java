
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    public TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int value) {
        root = insertNode(root, value);
    }

    private TreeNode insertNode(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }

        if (value < node.value) {
            node.left = insertNode(node.left, value);
        } else if (value > node.value) {
            node.right = insertNode(node.right, value);
        }

        return node;
    }

    public int findMinValue() {
        if (root == null) {
            System.out.println("Tree is empty.");
        }

        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    public void delete(int value) {
        root = deleteNode(root, value);
    }

    private TreeNode deleteNode(TreeNode node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.value) {
            node.left = deleteNode(node.left, value);
        } else if (value > node.value) {
            node.right = deleteNode(node.right, value);
        } else {
            // Node to be deleted found

            // Case 1: No child or one child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Case 2: Two children
            node.value = findMinValue();
            node.right = deleteNode(node.right, node.value);
        }

        return node;
    }
}

class HeapOfBSTs {
    private BinarySearchTree[] heap;
    private int size;
    private int capacity;

    public HeapOfBSTs(int capacity) {
        heap = new BinarySearchTree[capacity];
        this.capacity = capacity;
        size = 0;
    }

    public void insert(BinarySearchTree bst) {
        if (size == capacity) {
            throw new IllegalStateException("Heap is full");
        }

        heap[size] = bst;
        heapifyUp(size);
        size++;
    }

    public BinarySearchTree delete() {
        if (size == 0) {
            System.out.println("Heap is empty.");
        }

        BinarySearchTree minBST = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;

        heapifyDown(0);

        return minBST;
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;

        while (index > 0 && heap[index].findMinValue() < heap[parentIndex].findMinValue()) {
            BinarySearchTree temp = heap[index];
            heap[index] = heap[parentIndex];
            heap[parentIndex] = temp;

            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int smallest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < size && heap[leftChild].findMinValue() < heap[smallest].findMinValue()) {
            smallest = leftChild;
        }

        if (rightChild < size && heap[rightChild].findMinValue() < heap[smallest].findMinValue()) {
            smallest = rightChild;
        }

        if (smallest != index) {
            BinarySearchTree temp = heap[index];
            heap[index] = heap[smallest];
            heap[smallest] = temp;

            heapifyDown(smallest);
        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print("BST " + i + ": ");
            printBST(heap[i].root);
            System.out.println();
        }
    }

    private void printBST(TreeNode node) {
        if (node != null) {
            printBST(node.left);
            System.out.print(node.value + " ");
            printBST(node.right);
        }
    }

}

public class Question2 {
    public static void main(String[] args) {
        BinarySearchTree bst1 = new BinarySearchTree();
        bst1.insert(10);
        bst1.insert(20);
        bst1.insert(30);

        BinarySearchTree bst2 = new BinarySearchTree();
        bst2.insert(15);
        bst2.insert(25);
        bst2.insert(35);

        BinarySearchTree bst3 = new BinarySearchTree();
        bst3.insert(5);
        bst3.insert(12);
        bst3.insert(40);

        HeapOfBSTs heap = new HeapOfBSTs(5);
        heap.insert(bst1);
        heap.insert(bst2);
        heap.insert(bst3);

        heap.printHeap();

        BinarySearchTree minBST = heap.delete();
        System.out.println("Minimum value in the deleted BST: " + minBST.findMinValue());
    }
}
