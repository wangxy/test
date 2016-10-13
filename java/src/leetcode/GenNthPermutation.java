package main.java.algorithms;

public class GenNthPermutation {

    public String getPermutation(int n, int k) {
        int[] cnt = new int[n];
        cnt[0] = 1;
        for (int i = 1; i < n; i++) {
            cnt[i] = (i + 1) * cnt[i - 1];
        }

        int[] idx = new int[n];
        int z = k  - 1;
        for (int i = 0; i < n - 1; i++) {
            idx[i] = (z) / cnt[n - 2 - i];
            z = (z) % cnt[n - 2 -i];
        }
        idx[n-1] = 0;


        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            used[i] = false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = findNth(used, idx[i]);
            used[x] = true;
            sb.append(x + 1);
        }
        return sb.toString();
    }
    private int findNth(boolean[] used, int cnt) {
        int x = 0;
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                x++;
            }
            if (x == cnt + 1) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        GenNthPermutation g = new GenNthPermutation();
        for (int i = 1; i < 30; i++) {
            System.out.println(g.getPermutation(5, i));
        }
    }

}