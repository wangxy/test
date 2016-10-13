/**
 * Created by xwang on 5/26/16.
 */
public class MathTest {

    public void testTrangleFunctions(){
        double x = 45;
        double radian = Math.toRadians(x);

        System.out.println("Sin of 45: " + Math.sin(radian));
        System.out.println("Cos of 45: " + Math.cos(radian));
        System.out.println("Tang of 45: " + Math.tan(radian));
        System.out.println("Atan of 45: "  + Math.atan(radian));
        System.out.println(1/Math.sqrt(2));

        x = 30;
        radian = Math.toRadians(x);
        System.out.println("Sin of 30: " + Math.sin(radian));
        System.out.println("Cos of 30: " + Math.cos(radian));
        System.out.println("Tang of 30: " + Math.tan(radian));
        System.out.println("Atan of 30: "  + Math.atan(radian));

    }

    public static void main(String[] res) {
        new MathTest().testTrangleFunctions();
        System.out.println(Math.ulp(1.34678));
    }

}
