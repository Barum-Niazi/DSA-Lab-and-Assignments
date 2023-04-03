import java.util.Random;

class CQueue {
    int size = 6;
    int front, rear;
    int items[] = new int[size];

    CQueue() {
        front = -1;
        rear = -1;
    }

    boolean isFull() {
        if (front == 0 && rear == size - 1) {
            return true;
        }
        if (front == rear + 1) {
            return true;
        }
        return false;
    }

    boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }

    void enQueue(int element) {
        if (isFull())
            System.out.println("Queue is full");
        else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % size;
            items[rear] = element;
            System.out.println("Inserted " + element);
        }
    }

    void deQueue() {
        int element;
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            element = items[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size;
            }
            System.out.println("Deleted -> " + element);
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}