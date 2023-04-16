import javax.xml.transform.Templates;

public class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        head = null;
        tail = null;

    }

    void insert(int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            head.prev = null;
            tail = temp;
            tail.next = null;
        } else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
            tail.next = null;
        }
    }

    void delete() {
        if (head == null && tail == null) {
            System.out.println("List is empty");
        } else {
            head = head.next;
        }
    }

    void displayList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    class Node {
        int data;
        Node next;
        Node prev;

        Node() {

        }

        Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.delete();

        list.displayList();
    }
}