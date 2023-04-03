class Stack {
    private int top;
    private int[] stack;
    private int size;

    public Stack(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    public void push(int data) {
        if (top == size - 1) {
            System.out.println("Stack is full");
        } else {
            top++;
            stack[top] = data;
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int data = stack[top];
            top--;
            return data;
        }
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stack[top];
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }
}

public class Convertor {
    public static void main(String[] args) {

        // converting binary to decimal

        int binary = 101010;
        int decimal = 0;
        int power = 0;
        Stack stack = new Stack(10);

        while (binary != 0) {
            int rem = binary % 10;
            stack.push(rem);
            binary = binary / 10;
        }
        while (!stack.isEmpty()) {
            int rem = stack.pop();
            decimal += rem * Math.pow(2, power);
            power++;
        }

        System.out.println(decimal);

        // converting decimal to binary
        decimal = 42;
        binary = 0;
        power = 0;

        Stack stack2 = new Stack(10);

        while (decimal != 0) {
            int rem = decimal % 2;
            stack2.push(rem);
            decimal = decimal / 2;
        }

        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop());
        }
    }
}