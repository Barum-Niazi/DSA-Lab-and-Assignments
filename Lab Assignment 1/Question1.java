import java.util.Stack;

class QueueWithStack<T> {
    Stack<T> stack1 = new Stack();
    Stack<T> stack2 = new Stack();

    QueueWithStack() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void enqueue(T data) {
        stack1.push(data);
    }

    public void dequeue() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        if (stack2.empty()) {
            while (!stack1.empty())
                stack2.push(stack1.pop());
        }
        System.out.println("Dequeued: " + stack2.pop());

    }

    public boolean isEmpty() {
        if (stack1.empty() && stack2.empty()) {
            return true;
        } else
            return false;
    }

}

public class Question1 {
    public static void main(String[] args) {
        QueueWithStack queue = new QueueWithStack<Integer>();

        queue.enqueue(1);
        queue.enqueue(5);

        queue.dequeue();
        queue.enqueue(1);
        queue.enqueue(5);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

    }
}
