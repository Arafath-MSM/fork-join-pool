import java.util.Scanner;

public class Factorial_number {
    public static int calculateFactorial(int n)
    {
        if (n == 0 || n == 1)
        {
            return 1;
        }
        else
        {
            return n * calculateFactorial(n - 1);
        }
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        //System.out.println("Enter the Number:");
        int factorial = calculateFactorial(number);
        System.out.println("Factorial of " + number + " is " + factorial);
    }
}
