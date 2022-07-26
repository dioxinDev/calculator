package mobi.reid.calculator.view;

import mobi.reid.calculator.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI extends JFrame {
    Controller controller;
    GridBagLayout gridBagLayout;
    public SimpleGUI(String title, Controller controller) throws HeadlessException {
        super(title);
        this.controller = controller;
        setSize(400, 500);

        JPanel panel=new JPanel();
        panel.setBounds(5, 5, 390, 490);
        add(panel);

        gridBagLayout = new GridBagLayout();
        panel.setLayout(gridBagLayout);

        createTextField(panel);
        createAllButtons(panel);



    }

    private void createTextField(JPanel panel) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JTextField textField=new JTextField(9);
        gridBagLayout.setConstraints(textField,constraints);
        textField.setBounds(5, 5, 100, 50);
        textField.setBackground(Color.WHITE);
        textField.setEditable(false);
        textField.setFont(textField.getFont().deriveFont(50f));
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(textField,constraints);
    }

    private void createAllButtons(JPanel panel) {

        String[] buttonLabels = {"AC","C","/","7","8","9","*","4","5","6","+","1","2","3","-","0",".","="};
        int xmax = 4;
        int ymax = 5;
        GridBagConstraints constraints;

        int functionPosition = 0;
        String function;
        for (int y = 1; y <= ymax; y++){
            for (int x = 0; x < xmax; x++){
                function = buttonLabels[functionPosition];
                constraints = new GridBagConstraints();
                constraints.fill = GridBagConstraints.HORIZONTAL;
                constraints.gridx = x;
                constraints.gridy = y;

                if(function == "AC"||function == "0"){
                    constraints.gridwidth = 2;
                    x++;
                } else {
                    constraints.gridwidth = 1;
                }

                    JButton button = new JButton(function);
                    button.addActionListener(new ActionListenerButton(function));
                    button.setVisible(true);
                    panel.add(button,constraints);
                    functionPosition++;
                }
            }


    }

    public class ActionListenerButton implements ActionListener{
        String function;
         public ActionListenerButton(String function){
            this.function = function;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            controller.handleEvent(function);
        }
    }

}
