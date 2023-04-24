public class Part1 {
    public static int[] countingSort(int[] arr, int max) {
        int[] count = new int[max+1];
        int[] sorted = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                sorted[index++] = i;
            }
        }
        return sorted;
    }

    public static int[] countingSortLessOrEqual(int[] arr, int max) {
        int[] count = new int[max+1];
        int[] sorted = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }
        for (int i = arr.length-1; i >= 0; i--) {
            sorted[--count[arr[i]]] = arr[i];
        }
        return sorted;
    }


}
