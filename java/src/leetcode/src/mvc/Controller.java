package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by xwang on 5/23/16.
 */
public class Controller {
    Model model;
    View view;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        this.view.addActionListener(new CalculatorEL());
    }

    class CalculatorEL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int val1 = view.getFirstNumber();
            int val2 = view.getSecondNumber();
            model.add(val1, val2);
            view.setResult(model.getResult());
        }
    }
}
