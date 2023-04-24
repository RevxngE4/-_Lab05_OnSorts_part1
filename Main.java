import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //1.
        int[] arr1 = {4, 2, 8, 3, 9, 3, 1, 1, 3};
        int[] arr2 = {5, 4, 8, 3, 9, 3, 1, 0, 9};
        int[] sorted1 = Part1.countingSort(arr1, 9);
        int[] sorted2 = Part1.countingSortLessOrEqual(arr2, 9);
        System.out.println(Arrays.toString(sorted1));
        System.out.println(Arrays.toString(sorted2));
        //2.
        int[] arr2_1 = { 123, 45, 12, 67, 890, 34, 21 };
        Part2.digitalSortingArrayList(arr2_1);
        System.out.println(Arrays.toString(arr2_1));
        int[] arr2_2 = { 34, 56, 12, 67, 234, 34, 0 };
        Part2.digitalSortingSingleDigit(arr2_2);
        System.out.println(Arrays.toString(arr2_2));
        //3.
        double [] arr3_0 = {0.63, 0.19, 0.09, 0.46, 0.61, 0.85, 0.40, 0.60, 0.71, 0.41};
        Part3.bucketSort1(arr3_0);
        System.out.println(Arrays.toString(arr3_0));
        double[] arr3_1 = {0.1, 0.5, 0.2, 0.8, 0.3, 0.6, 0.4, 0.9, 0.7, 0.0};
        Part3.BucketSort2.bucketSort(arr3_1);
        System.out.println(Arrays.toString(arr3_1));
        double[] arr3_2 = {0.1, 0.5, 0.2, 0.8, 0.3, 0.6, 0.4, 0.9, 0.7, 0.0};
        Part3.bucketSort3(arr3_2);
        System.out.println(Arrays.toString(arr3_2));


    }


}