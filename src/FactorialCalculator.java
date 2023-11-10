import java.util.Scanner;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;
public class FactorialCalculator extends RecursiveTask<Long> {
    private final int n;

    public FactorialCalculator(int n)
    {
        this.n = n;
    }

    @Override
    protected Long compute()
    {
        if (n <= 1)
        {
            return 1L;
        }
        else
        {
            FactorialCalculator subTask = new FactorialCalculator(n - 1);
            subTask.fork();
            return n * subTask.join();
        }
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        FactorialCalculator factorialTask = new FactorialCalculator(number);
        long result = forkJoinPool.invoke(factorialTask);
        System.out.println("Factorial of " + number + " is: " + result);
    }
}

