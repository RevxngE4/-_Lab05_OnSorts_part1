import java.util.ArrayList;

public class Part2 {
    public static void digitalSortingArrayList(int[] arr) {
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayList<>();
        }

        int maxDigits = getMaxDigits(arr);
        int divisor = 1;

        for (int i = 0; i < maxDigits; i++) {
            for (int j = 0; j < arr.length; j++) {
                int digit = (arr[j] / divisor) % 10;
                buckets[digit].add(arr[j]);
            }

            int index = 0;
            for (ArrayList<Integer> bucket : buckets) {
                for (int num : bucket) {
                    arr[index++] = num;
                }
                bucket.clear();
            }

            divisor *= 10;
        }
    }

    private static int getMaxDigits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return (int) Math.log10(max) + 1;
    }
    public static void digitalSortingSingleDigit(int[] arr) {
        int maxDigits = getMaxDigits(arr);
        int divisor = 1;

        for (int i = 0; i < maxDigits; i++) {
            int[] counts = new int[10];
            int[] output = new int[arr.length];

            for (int j = 0; j < arr.length; j++) {
                int digit = (arr[j] / divisor) % 10;
                counts[digit]++;
            }

            for (int j = 1; j < 10; j++) {
                counts[j] += counts[j - 1];
            }

            for (int j = arr.length - 1; j >= 0; j--) {
                int digit = (arr[j] / divisor) % 10;
                output[counts[digit] - 1] = arr[j];
                counts[digit]--;
            }

            System.arraycopy(output, 0, arr, 0, arr.length);
            divisor *= 10;
        }
    }

}
