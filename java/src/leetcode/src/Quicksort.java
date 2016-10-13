package main.java.algorithms.src;

import java.util.Arrays;

/**
 * Created by xwang on 7/11/16.
 */
public class Quicksort {

    public void sortArray(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int partition = partition(arr, start, end);
        sortArray(arr, start, partition - 1);
        sortArray(arr, partition + 1, end);
    }

     private int partition(int[] arr, int start, int end) {
         int pivot = arr[end];
         int i = start;
         for (int j = start; j <= end - 1; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
         swap(arr, i, end);

        System.out.println(Arrays.toString(arr) + " partition: "
                + i + " start: " + start + " end: " + end + " pivot: " + pivot);
        return i;
    }
    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {19, 2, 7, 8, 10, 5, 20};
        Quicksort qs = new Quicksort();
        qs.sortArray(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
