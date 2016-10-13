package main.java.algorithms;

/**
 * Created by xwang on 8/17/16.
 */
public class SearchInRotatedArray {
    public int searchWithoutFindMin(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi)/2;
            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < arr[hi]) {
                if (target >= arr[mid] && target <= arr[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            if (arr[mid] > arr[hi]) {
                if (target >= arr[lo] && target <= arr[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return -1;
    }

    // first solution
    public int search(int[] arr, int target) {
        int minIdx = findMin(arr);
        int maxIdx = minIdx == 0 ? arr.length - 1 : minIdx - 1;
        if (arr[minIdx] > target || arr[maxIdx] < target) {
            return -1; // out of range
        }
        int start = minIdx;
        int end = maxIdx;
        if (arr[arr.length - 1] > target) {
            end = arr.length - 1;
        } else if (arr[arr.length - 1] < target) {
            start = 0;
        } else {
            return arr.length - 1;
        }

        // have found the range we want to search for. Go through the normal
        // binary search process;
        while (start <= end) {
            int mid = (start + end)/2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int findMin(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = (start + end)/2;
            if (arr[mid] < arr[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        SearchInRotatedArray sra = new SearchInRotatedArray();
        //System.out.println(sra.search(new int[]{1, 2, 3}, 2));
        System.out.println(sra.searchWithoutFindMin(new int[]{3, 4, 5, 6, 1, 2}, 2));
        System.out.println(sra.searchWithoutFindMin(new int[]{6, 1, 2, 3, 4, 5}, 2));
        System.out.println(sra.searchWithoutFindMin(new int[]{1, 2, 3, 4, 5}, 2));

    }
}
