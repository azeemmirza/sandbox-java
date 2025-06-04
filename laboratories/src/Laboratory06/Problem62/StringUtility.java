package Laboratory06.Problem62;

import javax.swing.*;

public class StringUtility {
    public static void main(String[] args) {
        // Create the main frame for the GUI
        JFrame frame = new JFrame("String Utility");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);

        // Create input and output text fields, buttons, and panel
        JTextField input = new JTextField(20);
        JTextField output = new JTextField(20);
        output.setEditable(false);

        // Create buttons for counting letters, reversing letters, and removing duplicates
        JButton countBtn = new JButton("Count Letters");
        JButton reverseBtn = new JButton("Reverse Letters");
        JButton removeBtn = new JButton("Remove Duplicates");

        // Set layout and add components to the panel
        JPanel panel = new JPanel();
        panel.add(new JLabel("Input:"));
        panel.add(input);
        panel.add(new JLabel("Output:"));
        panel.add(output);
        panel.add(countBtn);
        panel.add(reverseBtn);
        panel.add(removeBtn);

        // Add action listeners to the buttons
        countBtn.addActionListener(e -> output.setText(String.valueOf(input.getText().length())));
        // Reverse the input string and set it to output
        reverseBtn.addActionListener(e -> output.setText(new StringBuilder(input.getText()).reverse().toString()));

        // Remove duplicates from the input string and set it to output
        removeBtn.addActionListener(e -> {
            String text = input.getText();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (result.indexOf(String.valueOf(c)) == -1) { // If not already in result
                    result.append(c);
                }
            }
            output.setText(result.toString());
        });

        // Set the layout and add the panel to the frame
        frame.add(panel);
        frame.setVisible(true);
    }
}
