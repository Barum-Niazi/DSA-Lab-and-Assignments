class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

class Heap {
    private ListNode head;

    public Heap() {
        head = null;
    }

    public void add(int value) {
        ListNode newNode = new ListNode(value);

        if (head == null) {
            head = newNode;
        } else {
            ListNode curr = head;
            ListNode prev = null;

            while (curr != null && curr.value < value) {
                prev = curr;
                curr = curr.next;
            }

            if (prev == null) {
                newNode.next = head;
                head = newNode;
            } else {
                newNode.next = prev.next;
                prev.next = newNode;
            }
        }

        heapifyUp(newNode);
    }

    public int delete() {
        if (head == null) {
            System.out.println("Heap is empty.");
            return -1;
        }

        int deletedValue = head.value;
        head = head.next;

        if (head != null) {
            heapifyDown(head);
        }

        return deletedValue;
    }

    private void heapifyUp(ListNode node) {
        ListNode current = node;
        ListNode parent = getParentNode(current);

        while (parent != null && current.value < parent.value) {
            int temp = current.value;
            current.value = parent.value;
            parent.value = temp;

            current = parent;
            parent = getParentNode(current);
        }
    }

    private void heapifyDown(ListNode node) {
        ListNode current = node;

        while (current != null) {
            ListNode smallestChild = getSmallestChild(current);

            if (smallestChild == null || current.value < smallestChild.value) {
                break;
            }

            int temp = current.value;
            current.value = smallestChild.value;
            smallestChild.value = temp;

            current = smallestChild;
        }
    }

    private ListNode getParentNode(ListNode node) {
        ListNode current = head;
        ListNode parent = null;

        while (current != null && current != node) {
            parent = current;
            current = current.next;
        }

        return parent;
    }

    private ListNode getSmallestChild(ListNode node) {
        ListNode smallestChild = null;

        if (node != null) {
            ListNode leftChild = node.next;
            if (leftChild != null) {
                smallestChild = leftChild;
                ListNode rightChild = leftChild.next;
                if (rightChild != null && rightChild.value < leftChild.value) {
                    smallestChild = rightChild;
                }
            }
        }

        return smallestChild;
    }

    public void printHeap() {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}

public class Question1 {
    public static void main(String[] args) {
        Heap heap = new Heap();

        heap.add(10);
        heap.add(20);
        heap.add(15);
        heap.add(30);
        heap.add(5);

        System.out.println("Heap:");
        heap.printHeap();

        int deletedValue = heap.delete();
        System.out.println("Deleted element: " + deletedValue);

        System.out.println("Heap after deletion:");
        heap.printHeap();
    }
}
