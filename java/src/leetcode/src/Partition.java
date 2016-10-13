import java.util.ArrayList;
import java.util.List;

public class Partition {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s == null || s.length() <= 1) {
            if (s != null && s.length() >= 0) {
                List<String> t = new ArrayList<String>();
                t.add(s);
                res.add(t);
            }
            return res;
        }

        helper(res, s.toCharArray(), 0, s.length() - 1);
        return res;
    }

    private void helper(List<List<String>> out, char[] chars, int cur, int last) {
        List<String> arr = new ArrayList<String>();
        arr.add(String.valueOf(chars[cur]));
        out.add(arr);

        int index = 1;
        while (index <= last) {
            List<List<String>> tmp = new ArrayList<List<String>>();
            for (List<String> x : out) {
                String lastStr = x.get(x.size() - 1);
                String newStr = lastStr + String.valueOf(chars[index]);
                if (isPalin(newStr)) {
                    ArrayList<String> newArr = new ArrayList<String>();
                    for (int i = 0; i < x.size() - 1; i++) {
                        newArr.add(x.get(i));
                    }
                    newArr.add(newStr);
                    tmp.add(newArr);
                }
                x.add(String.valueOf(chars[index]));
            }
            out.addAll(tmp);
           index++;
        }
    }

    private boolean isPalin(String str) {
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Partition p = new Partition();
        List<List<String>> res = p.partition("aba");
        for (List<String> arr : res) {
            for (String str : arr) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}