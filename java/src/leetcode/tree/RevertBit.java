package main.java.algorithms.tree;

/**
 * Created by xwang on 9/6/16.
 */
public class RevertBit {
    public int revert(int val) {
        int mask = 0x00000001;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + (val & mask);
            System.out.println(i + " res: " + res + " cur: " + (val & mask) + " val : " + val);
            val = val >> 1;
        }
        return  res;
    }

    public static String toString(int val) {
        System.out.println(val);
        int mask = 0x00000001;
        char[] res = new char[32];
        for (int i = 0; i < 32; i++) {
            res[31 - i] = (val & mask) == 0 ? '0': '1';
            val = val >> 1;
        }
        return new String(res);
    }


    public static void main(String[] args){
        RevertBit rb = new RevertBit();
        //System.out.println(RevertBit.toString(rb.revert(0)));
        //System.out.println(RevertBit.toString(rb.revert(0xF0000000)));
        System.out.println(RevertBit.toString(rb.revert(0xF0F0F000)));


    }
}
