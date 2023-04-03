
class CDLL {
    Node head;
    Node tail;

    int size;

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    CDLL() {
        head = new Node(0, null, null);
        tail = new Node(0, null, null);
        head.next = tail;
        tail.prev = head;
    }

    // inserts an element between head and head.next
    public void addStart(int data) {
        Node newNode = new Node(data, head.next, head);
        head.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    // inserts an element between tail and tail.prev
    public void addEnd(int data) {
        Node newNode = new Node(data, tail, tail.prev);
        tail.prev = newNode;
        newNode.prev.next = newNode;
        size++;
    }

    public void removeStart() {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }
        Node tempPrev = head.next.prev;
        Node tempNext = head.next.next;

        tempPrev.next = tempNext;
        tempNext.prev = tempPrev;

        size--;
    }

    public void removeEnd() {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }
        Node tempPrev = tail.prev.prev;
        Node tempNext = tail.prev.next;

        tempPrev.next = tempNext;
        tempNext.prev = tempPrev;

        size--;

    }

    public void displayList() {
        Node temp = head.next;
        while (temp != tail) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void size() {
        System.out.println("The size of the linked list is: " + size);
    }


    public static CDLL concat(CDLL list1, CDLL list2) {
        CDLL concatList;
        concatList = list1;
        Node temp = concatList.tail.prev;
        temp.next = list2.head.next;
        list2.head.next.prev = temp;
        list2.tail.prev.next = concatList.tail;
        concatList.tail.prev = list2.tail.prev;
        return concatList;
    }

    public boolean isSorted() {
        Node temp = head.next;
        while (temp != tail) {
            if (temp.data > temp.next.data)
                return false;

            temp = temp.next;
        }
        return true;
    }

    public static void mergeLists(CDLL list1, CDLL list2) {
        if (!list1.isSorted()) {
            System.out.println("List 1 is not sorted, cannot merge");
            return;
        }
        if (!list2.isSorted()) {
            System.out.println("List 2 is not sorted, cannot merge");
            return;
        }

        CDLL mergedList = new CDLL();
        Node temp1 = list1.head.next;
        Node temp2 = list2.head.next;

        while (temp1 != list1.tail && temp2 != list2.tail) {
            if (temp1.data > temp2.data) {
                mergedList.addEnd(temp1.data);
                temp1 = temp1.next;
            } else {
                mergedList.addEnd(temp2.data);
                temp2 = temp2.next;
            }
        }
        while (temp1 != list1.tail) {
            mergedList.addEnd(temp1.data);
            temp1 = temp1.next;
        }

        while (temp2 != list2.tail) {
            mergedList.addEnd(temp2.data);
            temp2 = temp2.next;
        }

        mergedList.displayList();
    }
}

public class Main {
    public static void main(String[] args) {
        CDLL list = new CDLL();
        list.addEnd(5);
        // list.addStart(2);
        list.addEnd(4);
        list.addEnd(3);
        // list.addStart(5);
        System.out.println("List 1 without concatenation: ");
        list.displayList();

        CDLL list2 = new CDLL();
        list2.addStart(2);
        list2.addStart(4);
        list2.addStart(6);
        System.out.println();
        System.out.println("List 2 without concatenation: ");
        list2.displayList();

        CDLL concatList = CDLL.concat(list, list2);
        System.out.println();
        System.out.println("Concatenated list is: ");
        concatList.displayList();

        System.out.println();
        System.out.println("Merged list is: ");
        CDLL.mergeLists(list, list2);
    }
}