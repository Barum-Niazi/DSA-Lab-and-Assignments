class CircularQueue {
    private int capacity;
    private int front;
    private int rear;
    private int[] queue;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.front = -1;
        this.rear = -1;
        this.queue = new int[capacity];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Circular Queue is full. Data cannot be inserted.");
        } else if (isEmpty()) {
            front = 0;
            rear = 0;
            queue[rear] = data;
            System.out.println("Data inserted: " + data);
        } else {
            rear = (rear + 1) % capacity;
            queue[rear] = data;
            System.out.println("Data inserted: " + data);
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Circular Queue is empty. No data to dequeue.");
        } else if (front == rear) {
            int data = queue[front];
            front = -1;
            rear = -1;
            System.out.println("Data dequeued: " + data);
        } else {
            int data = queue[front];
            front = (front + 1) % capacity;
            System.out.println("Data dequeued: " + data);
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Circular Queue is empty.");
        } else {
            System.out.println("Circular Queue:");
            if (rear >= front) {
                for (int i = front; i <= rear; i++) {
                    System.out.print(queue[i] + " ");
                }
            } else {
                for (int i = front; i < capacity; i++) {
                    System.out.print(queue[i] + " ");
                }
                for (int i = 0; i <= rear; i++) {
                    System.out.print(queue[i] + " ");
                }
            }
            System.out.println();
        }
    }
}

public class Question3 {
    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.display();
        circularQueue.dequeue();
        circularQueue.display();
        circularQueue.enqueue(4);
        circularQueue.enqueue(5);
        circularQueue.display();
        circularQueue.enqueue(6);
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.display();
    }
}
