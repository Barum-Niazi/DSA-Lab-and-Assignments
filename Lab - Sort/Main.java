import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int array[] = new int[5];
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 5 numbers: ");

        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println("The sorted array is: ");
        
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
