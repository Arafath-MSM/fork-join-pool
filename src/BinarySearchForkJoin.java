import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class BinarySearchForkJoin extends RecursiveTask<Integer> {
    private final int[] sortedArray;
    private final int target;
    private final int start;
    private final int end;

    public BinarySearchForkJoin(int[] sortedArray, int target, int start, int end)
    {
        this.sortedArray = sortedArray;
        this.target = target;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute()
    {
        if (start > end)
        {
            return -1;
        }

        int mid = (start + end) / 2;

        if (sortedArray[mid] == target)
        {
            return mid;
        }
        else if (sortedArray[mid] < target)
        {
            BinarySearchForkJoin rightTask = new BinarySearchForkJoin(sortedArray, target, mid + 1, end);
            rightTask.fork();
            return rightTask.join();
        }
        else
        {
            BinarySearchForkJoin leftTask = new BinarySearchForkJoin(sortedArray, target, start, mid - 1);
            leftTask.fork();
            return leftTask.join();
        }
    }

    public static void main(String[] args)
    {
        int[] sortedArray = {11, 4, 2, 9, 19, 1, 3, 25};
        int target = 9;

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        BinarySearchForkJoin searchTask = new BinarySearchForkJoin(sortedArray, target, 0, sortedArray.length - 1);
        int result = forkJoinPool.invoke(searchTask);

        if (result != -1)
        {
            System.out.println("Element " + target + " found at index: " + result);
        }
        else
        {
            System.out.println("Element " + target + " not found in the array.");
        }
    }
}
