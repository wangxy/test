package mvc;

/**
 * Created by xwang on 5/23/16.
 */
public class MVCTest {
    public static void main(String[] args) {
        View v = new View();
        Model m = new Model();
        Controller c = new Controller(m, v);
        v.setVisible(true);
    }
}
