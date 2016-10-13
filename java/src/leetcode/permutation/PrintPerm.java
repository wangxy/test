package main.java.algorithms.permutation;

import java.util.ArrayList;

public class PrintPerm {
    public void printAll(int n) {
        ArrayList<ArrayList<Integer>>  res = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>>  tmp = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> x = new ArrayList<Integer>();
        x.add(0);
        x.add(1);
        res.add(x);
        x = new ArrayList<Integer>();
        x.add(1);
        x.add(0);
        res.add(x);

        for (int i = 2; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                for (ArrayList<Integer> perm : res) {
                    ArrayList<Integer> newArr = (ArrayList<Integer>)perm.clone();
                    newArr.add(j, i);
                    tmp.add(newArr);
                }
            }
            res.clear();
            res.addAll(tmp);
            tmp.clear();
        }

        System.out.println("Total perm: " + res.size());
        for (ArrayList<Integer> arr: res) {
            for (Integer num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PrintPerm pp = new PrintPerm();
        pp.printAll(5);

    }


}