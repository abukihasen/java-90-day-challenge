public class ArrayUtils {
    public static int findMin(int[] numbers) {
        if(numbers==null || numbers.length==0){
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }
        return min;
    }

    public static int findMax(int[] numbers) {
        int max = numbers[0];
        if (numbers==null || numbers.length==0){
            throw new IllegalArgumentException("Array cannot be empty");
        }
        for (int i = 1; i < numbers.length; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static int[] reverseArray(int[] numbers) {
        if (numbers==null || numbers.length==0){
            throw new IllegalArgumentException("Array cannot be empty");
        }
        int last = numbers.length;
        int[] revArray = new int[last];
        for (int i = 0; i < last; i++) {
            revArray[i] = numbers[last - 1 - i];
        }

        return revArray;
    }

    public static int binarySearch(int numbers[], int target) {
        if (numbers==null || numbers.length==0){
            throw new IllegalArgumentException("Array cannot be empty");
        }
        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        System.out.println("Target not found");
        return -1;
    }

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Minimum: " + findMin(numbers));
        System.out.println("Maximum: " + findMax(numbers));

        int[] myNumbers = reverseArray(numbers);

        System.out.print("Reversed array: ");

        for (int rev : myNumbers) {
            System.out.print(rev + " ");
        }
        System.out.println();
        System.out.print("Original array: ");
        for (int org : numbers) {
            System.out.print(org + " ");
        }
        System.out.println();

        int searched = binarySearch(numbers, 30);
        binarySearch(numbers, 70);
        if (searched == -1) {
            System.out.println("Target not found");
        } else {
            System.out.println("Target found at index " + searched);
        }
    }
}
