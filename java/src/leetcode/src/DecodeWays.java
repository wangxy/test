package main.java.algorithms.src;

/**
 * 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 */
public class DecodeWays {

    public int decodeWays(String number) {
        // basic idea, use dynamic programming
        // formula:
        // if number[i] < 6 and number[i-1] < 3, we can either have all the code options
        // of number[i-2] + 2
        // if number[i] < 6 and number[i-1] > 3, cannot combine with previous
        // number[i-1]
        // if number[i] >= 6 and number[i-1] < 2, can have two options
        // if number[i] >= 6 and number[i-1] >= 2, cannot combine with previous

        if (number.length() <= 1) {
            return number.length();
        }
        char[] carr = number.toCharArray();
        int[] decodeWays = new int[carr.length];
        decodeWays[0] = 1;
        for (int i = 1; i < number.length(); i++) {
            if (carr[i] == '0') {
                // it must go together with the previous
                decodeWays[i] = decodeWays[i-1];
            } else {
                if (carr[i] <= '6') {
                    if (carr[i-1] < '3') {
                        if (i >= 2) {
                            decodeWays[i] = decodeWays[i - 2] + 2;
                        } else {
                            decodeWays[i] = 2;
                        }
                    } else {
                        decodeWays[i] = decodeWays[i-1];
                    }
                } else {
                    // carr[i] > '6'
                    if (carr[i - 1] < '2' && carr[i - 1] > '0') {
                        // can combine with previous or decode alone.
                        if (i >= 2) {
                            decodeWays[i] = decodeWays[i - 2] + 2;
                        } else {
                            decodeWays[i] = 2;
                        }
                    } else {
                        // can be decode alone.
                        decodeWays[i] = decodeWays[i-1];
                    }
                }
            }
        }
        return decodeWays[carr.length-1];
    }


    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();
        System.out.println(dw.decodeWays("123456"));
    }

}

/**
 *    int len = s.length();
 if (len == 0) {
 return 0;
 }

 int[] nums = new int[len+1];
 nums[0] = 1;
 nums[1] = s.charAt(0) == '0' ? 0: 1;
 for (int i = 2; i <= len; i++) {
 char c1 = s.charAt(i-1);
 char c0 = s.charAt(i-2);
 if (c1 != '0') {
 nums[i] += nums[i-1];
 }
 if (c0 == '1' || c0 == '2' && c1 <= '6') {
 nums[i] += nums[i-2];
 }
 }
 return nums[len];
 */