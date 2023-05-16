import java.util.Scanner;
import java.util.Stack;

class ReversePolishNotation {
    Stack<Integer> stack = new Stack<Integer>();
    Scanner input = new Scanner(System.in);

    public int calculate() {
        System.out.println("Enter numbers or operators or ''quit'' (in lowercase) to exit");
        String choice = null; // for expression
        do {
            choice = input.next();
            // choice = choice.toLowerCase();
            switch (choice) {
                case "+":
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a + b);
                    break;

                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a - b);
                    break;

                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a * b);
                    break;

                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    a = a / b;
                    stack.push(a);
                    break;

                default:
                    stack.push(Integer.parseInt(choice));
                    break;
            }
            for (int i = 0; i < stack.size(); i++) {
                System.out.print(stack.get(i) + " ");
            }
        } while (choice != "quit");
        return stack.pop();
    }

}

public class Question2 {
    public static void main(String[] args) {
        ReversePolishNotation rpn = new ReversePolishNotation();
        rpn.calculate();
    }
}
