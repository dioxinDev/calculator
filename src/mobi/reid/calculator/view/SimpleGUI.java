package mobi.reid.calculator.view;

import mobi.reid.calculator.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class SimpleGUI extends JFrame {
    Controller controller;
    public SimpleGUI(String title, Controller controller) throws HeadlessException {
        super(title);
        this.controller = controller;
        setSize(400, 500);



    }

}
