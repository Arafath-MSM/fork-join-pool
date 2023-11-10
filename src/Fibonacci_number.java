import java.util.Scanner;

public class Fibonacci_number {
    public static int calculateFibonacci(int n)
    {
        if (n <= 1)
        {
            return n;
        }
        else
        {
            return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
        }
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        System.out.print("Fibonacci Sequence: ");


        for (int i = 0; i < number; i++)
        {
            System.out.print(calculateFibonacci(i) + " ");
        }
    }
}
