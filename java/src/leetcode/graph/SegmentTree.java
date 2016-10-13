package main.java.algorithms.graph;

import java.util.Arrays;

/**
 * Created by xwang on 7/12/16.
 */
public class SegmentTree {
        int start;
        int end;
        int sum;
        SegmentTree left;
        SegmentTree right;

    SegmentTree(int[] nums, int start, int end) {
        System.out.println(Arrays.toString(nums) + " " + start + " " + end);
        if (start == end) {
            this.start = start;
            this.end = end;
            this.sum = nums[start];
            this.left = this.right = null;
        } else {
            int mid = (start + end) / 2;
            this.left = new SegmentTree(nums, start, mid);
            this.right = new SegmentTree(nums, mid + 1, end);
            this.start = start;
            this.end = end;
            this.sum = this.left.sum + this.right.sum;
        }
    }

    public int update(int idx, int newVal) {
        if (this.start == this.end && this.end == idx) {
            int diff = newVal - this.sum;
            this.sum = newVal;
            return diff;
        } else {
            int mid = (this.start + this.end)/2;
            int diff = idx <= mid ? this.left.update(idx, newVal) : this.right.update(idx, newVal);
            this.sum += diff;
            return diff;
        }
    }

    public void printTree() {
        System.out.println("[" + this.start + "-" + this.end + "] " + this.sum);
        if (this.left != null) {
            this.left.printTree();
        }
        if (this.right != null) {
            this.right.printTree();
        }
    }

    public static void main(String[] args) {
        SegmentTree st = new SegmentTree(new int[] {1, 2,3, 4, 5}, 0, 4);
        st.printTree();


    }
}
