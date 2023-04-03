class RandomQueue {
    int size = 5;
    int front, rear;
    int items[] = new int[size];

    RandomQueue() {
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
        int element = 0;
        if (isEmpty())
            System.out.println("Queue is empty");
        else {
            int random = (int) (Math.random() * (rear - front + 1) + front);
            element = items[random];
            if (random == front) {
                front = (front + 1) % size;
            } else if (random == rear) {
                rear = (rear - 1) % size;
            } else {
                for (int i = random; i < rear; i++) {
                    items[i] = items[i + 1];
                }
                rear = (rear - 1) % size;
            }
            System.out.println("Deleted -> " + element);
        }

    }
}

public class Problem {
    public static void main(String[] args) {
        RandomQueue rq = new RandomQueue();
        rq.enQueue(0);
        rq.enQueue(1);
        rq.enQueue(2);
        rq.enQueue(3);
        rq.enQueue(4);

        rq.deQueue();
        rq.deQueue();
        rq.deQueue();
    }
}
