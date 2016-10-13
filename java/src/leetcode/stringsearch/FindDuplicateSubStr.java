package main.java.algorithms.stringsearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class FindDuplicateSubStr {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) {
            return new ArrayList<String>();
        }
        // translate A -> 1 C -> 2 G-> 3, T-> 4
        byte[] code = new byte[26];
        code['A' - 'A'] = 1;
        code['C' - 'A'] = 2;
        code['G' - 'A'] = 3;
        code['T' - 'A'] = 4;

        Set<Long> all = new HashSet<Long>();
        Set<Long> dup = new HashSet<Long>();

        char[] chars = s.toCharArray();

        // first long val;
        long longVal = code[chars[0] - 'A'];
        for (int i = 1; i < 10; i++) {
            longVal = longVal * 10 + code[chars[i] - 'A'];
        }
        all.add(longVal);

        for (int i = 10; i < chars.length; i++) {
            longVal = (longVal % 1000000000) * 10 + code[chars[i] - 'A'];
            if (all.contains(longVal)) {
                dup.add(longVal);
            } else {
                all.add(longVal);
            }
        }

        List<String> result = new ArrayList<String>();
        char[] tmp = new char[10];
        for (Long val : dup) {
            for (int i = 0; i < 10; i++) {
                long lastDigit = val % 10;
                char r = 'A';
                if (lastDigit == 1) {
                    r = 'A';
                } else if (lastDigit == 2) {
                    r = 'C';
                } else if (lastDigit == 3) {
                    r = 'G';
                } else if (lastDigit == 4) {
                    r = 'T';
                }

                tmp[10 - i - 1] = r;
                val = val / 10;
            }
            result.add (new String(tmp));
        }
        return result;
    }

    public static void main(String[] args) {
        FindDuplicateSubStr dd = new FindDuplicateSubStr();
        dd.findRepeatedDnaSequences("AAAAAAAAAAA");
    }
}