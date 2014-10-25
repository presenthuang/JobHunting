package interviewQuestions;
import java.util.Scanner;



public class ReverseOrderInteger {
    private static Scanner scan;

    public static void main(String[] args) {
        System.out.println("\t\t\tEnter Number which you want to reverse.\n");
        scan = new Scanner(System.in);
        int number = scan.nextInt();
        int rev_number = reverse(number);
        System.out.println("\t\t\tYour reverse Number is = \"" + rev_number
                           + "\".\n");
    }

    private static int reverse(int number) {
        int backup = number;
        int count = 0;
        while (number != 0) {
            number = number / 10;
            count++;
        }
        number = backup;
        int sum = 0;
        for (int i = count; i > 0; i--) {
            int sum10 = 1;
            int last = number % 10;
            for (int j = 1; j < i; j++) {
                sum10 = sum10 * 10;
            }
            sum = sum + (last * sum10);
            number = number / 10;
        }
        return sum;
    }
}