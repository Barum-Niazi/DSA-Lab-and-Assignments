public class Question1 {
    private Node head;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be negative: " + index);
        }

        Node current = head;
        int currentIndex = 0;

        while (current != null) {
            if (currentIndex == index) {
                return current.data;
            }

            current = current.next;
            currentIndex++;
        }

        throw new IllegalArgumentException("Index is out of bounds: " + index);
    }

    // this method has a complexity of O(n)
    public void insertAt(int data, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be negative: " + index);
        }

        if (index == 0) {
            insert(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            int currentIndex = 0;

            while (current != null) {
                if (currentIndex == index - 1) {
                    newNode.next = current.next;
                    current.next = newNode;
                    return;
                }

                current = current.next;
                currentIndex++;
            }

            throw new IllegalArgumentException("Index is out of bounds: " + index);
        }
    }

    // The complexity of this method is O(n)
    public void removeAt(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be negative: " + index);
        }

        if (head == null) {
            throw new IllegalArgumentException("Index is out of bounds: " + index);
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            int currentIndex = 0;

            while (current != null) {
                if (currentIndex == index - 1) {
                    if (current.next == null) {
                        throw new IllegalArgumentException("Index is out of bounds: " + index);
                    }

                    current.next = current.next.next;
                    return;
                }

                current = current.next;
                currentIndex++;
            }

            throw new IllegalArgumentException("Index is out of bounds: " + index);
        }
    }

    // The complexity of this method is O(n)
    public void reverse() {
        Node previous = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
    }

    public static void main(String[] args) {
        Question1 list = new Question1();
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.display();

        list.reverse();
        list.display();
    }
}
