package user;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI {
    public static void main(String[] args) {

        // Create a new JFrame
        JFrame frame = new JFrame("GUI for Users ");

        // size of the frame
        frame.setSize(400, 300);

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new JLabel
        JLabel label1 = new JLabel("Enter your name:");
        JLabel label2 = new JLabel("Enter your EYC no.:");
        JLabel label3 = new JLabel("Enter your Aadhaar no.:");

        // Create a new JTextField
        JTextField textField1 = new JTextField(20);
        JTextField textField2 = new JTextField(20);
        JTextField textField3 = new JTextField(20);

        // Create a new JButton
        JButton button = new JButton("Submit");
        button.setBounds(150,100,100, 40);

        // Create a new JPanel
        JPanel panel = new JPanel(null);

        // Add the components to the panel
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(textField1);
        panel.add(textField2);
        panel.add(textField3);
        panel.add(button); //

        // Set the bounds for components
        label1.setBounds(10, 10, 150, 20);
        textField1.setBounds(170, 10, 200, 20);

        label2.setBounds(10, 40, 150, 20);
        textField2.setBounds(170, 40, 200, 20);

        label3.setBounds(10, 70, 150, 20);
        textField3.setBounds(170, 70, 200, 20);

        button.setBounds(150, 100, 100, 40);

        // Add the panel to the frame
        frame.add(panel);

        // Set the frame to be visible
        frame.setVisible(true);

         //Add ActionListener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField1.getText();
                // Do something with the input, for example:
                JOptionPane.showMessageDialog(frame, "Hello, " + input + "!");
            }
        }
        );
    }
}
