public class LinkedList {
    Node head;
    Node tail;

    public LinkedList() {
        head = null;
    }

    public void insertStart(int data) {
        Node e = new Node(data);
        if (head == null)
            head = e;
        else {
            head = e;
            e.next = head;
        }
    }

    // public void insertEnd(int data) {
    // Node e = new Node(data);
    // e.data = data;
    // if (head == null)
    // head = e;
    // else {
    // head.next = e;
    // }
    // }

    public void displayList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertStart(10);
        list.insertStart(20);
        list.insertStart(30);
        // list.insertEnd(40);
        // list.insertEnd(50);
        // list.insertEnd(60);
        // list.insertEnd(70);
        // list.insertEnd(80);
        // list.insertEnd(90);
        list.displayList();

    }
}

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node() {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}