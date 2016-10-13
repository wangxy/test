package mvc;

/**
 * Created by xwang on 5/23/16.
 */
public class Model {
    private int result;

    public void add(int num1, int num2) {
        result = num1 + num2;
    }

    public int getResult() {
        return result;
    }

}
