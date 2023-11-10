import java.util.Scanner;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;
public class FibonacciForkJoin extends RecursiveTask<Integer> {
    private final int n;
    public FibonacciForkJoin(int n)
    {
        this.n = n;
    }

    @Override
    protected Integer compute()
    {   if (n <= 1) {
            return n;
        }
        FibonacciForkJoin fibMinus1 = new FibonacciForkJoin(n - 1);
        FibonacciForkJoin fibMinus2 = new FibonacciForkJoin(n - 2);

        fibMinus1.fork();
        fibMinus2.fork();

        int result = fibMinus1.join() + fibMinus2.join();
        return result;
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        FibonacciForkJoin fibonacciTask = new FibonacciForkJoin(number);
        int result = forkJoinPool.invoke(fibonacciTask);
        System.out.println("Fibonacci Sequence of length " + number + ":");
        for (int i = 0; i < number; i++) {
            System.out.print(forkJoinPool.invoke(new FibonacciForkJoin(i)) + " ");
        }
    }
}
