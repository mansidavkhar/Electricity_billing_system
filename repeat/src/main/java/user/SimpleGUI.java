package user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI {
    public static void main(String[] args) {

        // Create a new JFram
        JFrame frame = new JFrame("User Information GUI");

        // Set the size of the frame
        frame.setSize(500, 300);

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use GridBagLayout for better control over component placement
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Create a new JLabel for input fields
        JLabel label1 = new JLabel("Enter your name:");
        JLabel label2 = new JLabel("Enter your EYC no.:");
        JLabel label3 = new JLabel("Enter your Aadhaar no.:");

        // Create new JTextFields
        JTextField textField1 = new JTextField(20);
        JTextField textField2 = new JTextField(20);
        JTextField textField3 = new JTextField(20);

        // Create a new JButton
        JButton button = new JButton("Submit");

        // Footer JLabel
        JLabel footer = new JLabel("D10C Roll no 21, 22, 28, 3", JLabel.CENTER);
        footer.setForeground(Color.GRAY);

        // Layout positioning
        gbc.insets = new Insets(10, 10, 10, 10); // Padding for components
        gbc.anchor = GridBagConstraints.WEST;

        // Adding label1 and textField1
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(label1, gbc);

        gbc.gridx = 1;
        frame.add(textField1, gbc);

        // Adding label2 and textField2
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(label2, gbc);

        gbc.gridx = 1;
        frame.add(textField2, gbc);

        // Adding label3 and textField3
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(label3, gbc);

        gbc.gridx = 1;
        frame.add(textField3, gbc);

        // Adding Submit button
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER; // Center the button
        frame.add(button, gbc);

        // Adding footer label
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2; // Span across 2 columns
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(footer, gbc);

        // Set frame to be visible
        frame.setVisible(true);

        // Add ActionListener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText().trim();
                String eycNo = textField2.getText().trim();
                String aadhaarNo = textField3.getText().trim();

                // Simple validation to check if all fields are filled
                if (name.isEmpty() || eycNo.isEmpty() || aadhaarNo.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Display a welcome message with the entered name
                    JOptionPane.showMessageDialog(frame, "Hello, " + name + "!\nEYC No.: " + eycNo + "\nAadhaar No.: " + aadhaarNo);
                }
            }
        });
    }
}
