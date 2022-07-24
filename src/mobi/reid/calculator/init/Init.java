package mobi.reid.calculator.init;

import mobi.reid.calculator.controller.Controller;
import mobi.reid.calculator.model.Model;
import mobi.reid.calculator.view.SimpleGUI;

public class Init {

    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        SimpleGUI view = new SimpleGUI("Simple Calculator", controller);
        view.setVisible(true);
    }

}
