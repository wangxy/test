package main.java.algorithms.src;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xwang on 5/24/16.
 */
public class RegularExpressionTest {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^\\d+(A)\\s+(\\d+)$");
        Matcher m = p.matcher("1A  2");
        System.out.println(m.matches());
        System.out.println(m.groupCount());
        for (int i = 0; i < m.groupCount() + 1; i++){
            System.out.println(m.group(i));
        }



    }

}
