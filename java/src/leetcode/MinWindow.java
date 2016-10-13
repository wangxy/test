package main.java;

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */


/*

Given k sorted arrays of integers of size n each, find the smallest range that includes at least one element from each of the k arrays.

arr1[] : [4, 7, 9, 12, 15]
arr2[] : [0, 8, 10, 14, 20]
arr3[] : [6, 12, 16, 30, 50]

[6, 8]

*/

class Solution {
    private class ArrayItem {
        int val;
        int idx;
        int src;

        ArrayItem(int val, int idx, int src) {
            this.val = val;
            this.idx = idx;  // index within the array
            this.src = src; // index of the array from the input
        }
    }

    public int[] minWindow(int[][] nums) {
        PriorityQueue<ArrayItem> minHeap = new PriorityQueue<ArrayItem>(nums.length,

                new Comparator<ArrayItem>() {
            @Override
            public int compare(ArrayItem o1, ArrayItem o2) {
                return o1.val - o2.val;
            }
        }
        );

        int wMin = Integer.MAX_VALUE;
        int wMax = Integer.MIN_VALUE;
        int resMin = Integer.MAX_VALUE;
        int resMax = Integer.MIN_VALUE;
        int distance = 0;

        // initialize minHeap
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(new ArrayItem(nums[i][0], 0, i));
            wMin = Math.min(wMin, nums[i][0]);
            wMax = Math.max(wMax, nums[i][0]);

            resMin = wMin;
            resMax = wMax;
            distance = wMax - wMin;
        }

        while (!minHeap.isEmpty()) {
            ArrayItem top = minHeap.poll();
            wMin = top.val;

            if (distance > wMax - top.val) {
                resMin = top.val;
                resMax = wMax;
                distance = resMax - resMin;
            }

            if (top.idx < nums[top.src].length - 1) {
                // has more element
                minHeap.add(new ArrayItem(nums[top.src][top.idx+1], top.idx+1, top.src));
                wMax = Math.max(wMax, nums[top.src][top.idx+1]);
            } else {
                break;
            }
        }

        System.out.println("min:" + resMin + " max: " + resMax);
        return new int[] {resMin, resMax};

    }

    public static void main(String[] args) {
        Solution s = new Solution();
 //    s.minWindow(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        s.minWindow(new int[][]{{4, 7, 9, 12, 15},
                {0, 8, 10, 14, 20},
                {6, 12, 16, 30, 50}});


    }
}
