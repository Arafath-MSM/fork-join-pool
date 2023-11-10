import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] array, int target, int low, int high)
    {
        if (low > high)
        {
            return -1;
        }

        int mid = (low + high) / 2;
        if (array[mid] == target)
        {
            return mid;
        }
        else if (array[mid] > target)
        {
            return binarySearch(array, target, low, mid - 1);
        }
        else
        {
            return binarySearch(array, target, mid + 1, high);
        }
    }
    public static void main(String[] args)
    {int[] sortedArray = {11, 4, 2, 9, 19, 1, 3, 25};
        Scanner input = new Scanner(System.in);
        int target = input.nextInt();
        //int target = 9;
        int result = binarySearch(sortedArray, target, 0, sortedArray.length - 1);

        if (result != -1)
        {
            System.out.println("Element " + target + " found at index " + result);
        }
        else {System.out.println("Element not found.");
        }
    }
}
