package main.java.algorithms.src;

/**
 * 33. Search in Rotated Sorted Array  QuestionEditorial Solution  My Submissions
 Total Accepted: 122945
 Total Submissions: 392763
 Difficulty: Hard
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 2, 4, 5, 6, 7, 10, 0, 1 search for 10
 0, 1, 2, 4, 5, 6, 7, 10 search for 1
 10, 0, 1, 2, 4, 5, 6, 7



 */
public class SearchRotated {
    public int search(int[] arr, int val) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            System.out.println("lo: " + lo + "hi:" + hi + "mid:" + mid);
            if (arr[mid] == val) {
                return mid;
            } else if (arr[mid] < val) {
                if (arr[mid] > arr[hi]) { // greater in this range
                    lo = mid + 1;
                } else {
                    if (arr[hi] >= val) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
            } else { // mid > val
                if (arr[mid] >= arr[lo]) {
                    if (arr[lo] <= val) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                } else {
                    // mid > val, arr[mid] < arr[lo]
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchRotated sr = new SearchRotated();
      //  System.out.println(sr.search(new int[]{7, 8, 9, 0, 1, 2, 3}, 2));
        System.out.println(sr.search(new int[]{3, 1}, 1));

    }
}
