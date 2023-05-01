import java.util.Stack;

public class Question2 {
    public static void main(String[] args) {
        Stack st = new Stack<Character>();

        String string1 = "racecar";
        string1 = string1.toLowerCase();
        char charArr[] = string1.toCharArray();
        char charArr2[] = new char[10];

        String result = null;

        for (int i = 0; i < charArr.length; i++) {
            st.push(charArr[i]);
        }

        for (int i = 0; i < charArr.length; i++) {
            charArr2[i] = (char) st.pop();
        }

        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] != charArr2[i]) {
                result = "Not palindrome";
                break;
            } else {
                result = "Palindrome";
            }

        }
        System.out.println("The word is: " + result);
    }
}
