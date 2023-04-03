import java.util.Scanner;

public class MinMax {
    public static void main(String[] args) {

        double temp = 0;
        double min = 0;
        Scanner input = new Scanner(System.in);

        double array[] = new double[3];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter array element " + (i + 1));
            array[i] = input.nextDouble();
            min = array[i];
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] > temp)
                temp = array[i];
            if (array[i] < min)
                min = array[i];
        }

        System.out.println("Maximum is " + temp);
        System.out.println("Minimum is " + min);
    }

}
