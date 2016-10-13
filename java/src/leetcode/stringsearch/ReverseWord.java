package main.java.algorithms.stringsearch;

/**
 * Created by xwang on 5/12/16.
 */
public class ReverseWord {
    public String reverse(String str) {
        if (str.isEmpty()) {
            return "";
        }
        char[] carr = str.toCharArray();
        int start = 0;
        int end = 0;
        for (int i = 0; i < carr.length; i++) {
            if (carr[i] == ' ') {
                reverse(carr, start, end);
                start = i + 1;
                end = i + 1;
            } else {
                end = i;
            }
        }
        if (carr[carr.length - 1] != ' ') {
            reverse(carr, start, end);
        }

        reverse(carr, 0, carr.length-1);
        return new StringBuilder().append(carr).toString();
    }

    private void reverse(char[] carr, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            char tmp = carr[i];
            carr[i] = carr[j];
            carr[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] res){
        ReverseWord rw = new ReverseWord();
        System.out.println(rw.reverse("the sky is blue"));
    }

}
