import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xwang on 5/25/16.
 */
public class LargestNumber {
    LargestNumber() {

    }

    public int compute(int[] nums) {
        Integer[] res = new Integer[nums.length];

        for (int idx = 0; idx < nums.length; idx++) {
            res[idx] = nums[idx];
        }

        Arrays.sort(res, new Comparator<Integer>(){
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        int len1 = String.valueOf(o1.toString()).length();
                        int len2 = String.valueOf(o2.toString()).length();
                        long val1 = Math.round(Math.pow(10, len2) * o1) + o2;
                        long val2 = Math.round(Math.pow(10, len1) * o2) + o1;

                        if (val1 > val2) {
                            return -1;
                        } else if (val1 == val2) {
                            return 0;
                        } else {
                            return 1;
                        }
                    }
                });

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            builder.append(String.valueOf(res[i]));
        }

        return Integer.parseInt(builder.toString());
    }

    public static void main(String[] args){
        LargestNumber num = new LargestNumber();
        int res = num.compute(new int[]{10, 12, 20, 40});
        System.out.println(res);
    }
}
