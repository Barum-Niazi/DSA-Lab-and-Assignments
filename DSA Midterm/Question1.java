class LinkedList {

    Node head = null;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    void traversal() {
        int counter = 0;
        int sum = 0;
        int product = 1;
        int min = head.data;
        int max = head.data;
        Node temp = head;
        while (temp != null) {
            sum = sum + temp.data;
            product = product * temp.data;
            if (min > temp.data)
                min = temp.data;
            if (max < temp.data)
                max = temp.data;
            temp = temp.next;
            counter++;
        }
        float average = sum / counter;
        System.out.println("The sum of the list is: " + sum);
        System.out.println("The product of the list is: " + product);
        System.out.println("The avg of the list is: " + average);
        System.out.println("The minimum of the list is: " + min);
        System.out.println("The maximum of the list is: " + max);

    }
}

public class Question1 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(20);
        list.add(10);
        list.add(40);
        list.add(-30);
        list.add(60);
        list.add(100);
        list.display();
        list.traversal();
    }
}
