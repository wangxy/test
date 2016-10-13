package mvc;

import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Created by xwang on 5/23/16.
 */
public class View extends JFrame{
    ActionListener al;
    JTextField tf1 = new JTextField(10);
    JLabel plus = new JLabel("+");
    JTextField tf2 = new JTextField(10);
    JButton calculateButton = new JButton("=");
    JTextField result = new JTextField(10);

    View(){
        JPanel panel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        //- See more at: http://www.newthinktank.com/2013/02/mvc-java-tutorial/#sthash.WfTNIjnk.dpuf
        panel.add(tf1);
        panel.add(plus);
        panel.add(tf2);
        panel.add(calculateButton);
        panel.add(result);

        this.add(panel);
    }

    public int getFirstNumber() {
        return Integer.parseInt(tf1.getText());
    }

    public int getSecondNumber() {
        return Integer.parseInt(tf2.getText());
    }

    public void setResult(int val) {
        result.setText(String.valueOf(val));
    }

    public void addActionListener(ActionListener al) {
        calculateButton.addActionListener(al);
    }
}
