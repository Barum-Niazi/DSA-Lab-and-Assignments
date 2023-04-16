public class Queue {

    private int front;
    private int rear;
    private int size;
    private int queue[];

    Queue(int c) {
        front = rear = -1;
        size = c;
        queue = new int[c];
    }

    void queueEnqueue(int data) {
        if (size == rear) {
            System.out.println("Queue is full");
            return;
        } else {
            rear++;
            queue[rear] = data;
        }
    }

    void queueDequeue() {
        if (front == rear) {
            System.out.println("Queue is empty");
            return;
        } else {
            for (int i = 0; i < rear; i++) {
                queue[i] = queue[i + 1];
            }
        }

        if (rear < size) {
            queue[rear] = -1;
            rear--;
        }
        return;
    }

    void display() {
        if (front == rear) {
            System.out.println("Queue is empty");
            return;
        } else {
            for (int i = 0; i <= rear; i++) {
                System.out.println(queue[i]);
            }
        }
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.display();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.display();
    }
}

class CircularQueue {
    int front;
    int rear;
    int size;
    int queue[];

    CircularQueue(int c) {
        front = rear = -1;
        size = c;
        queue = new int[c];
    }

    void enqueue(int data) {
        if (front == -1 && rear == -1) {
            rear = 0;
            front = 0;
            queue[rear] = data;
        } else if ((rear + 1) % size == front) {
            System.out.println("Queue is full");
            return;
        } else {
            rear = (rear + 1) % size;
            queue[rear] = data;
        }
    }

    void dequeue() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty");
            return;
        } else if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
    }

    void display() {
        int i = 0;
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty");
            return;
        } else {
            System.out.println("Elements of queue are: ");
            for (i = 0; i <= rear; i++) {
                System.out.println(queue[i]);
            }
        }
    }
}
