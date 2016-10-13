import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xwang on 5/23/16.
 */
public class HFactory {
    public static void main(String[] args) {
        Integer[] input = {1, 2, 3, 4, 5};

        Arrays.sort(input, new Comparator<Integer> (){
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1 * o1.compareTo(o2);
            }
        });

        System.out.println(Arrays.toString(input));

        for (int i = 0; i < input.length; i++){
            if (i == input[i] - 1) {
                return;
            }
        }

    }
}
