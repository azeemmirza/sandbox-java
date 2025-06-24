package Laboratory06.Problem62;

import javax.swing.*;
import java.awt.*;

public class Problem62 extends JFrame {
    private JTextField inputField;
    private JTextField outputField;

    public Problem62() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("String Utility");
        setSize(500, 150);
        centerFrameOnDesktop(this);

        inputField = new JTextField(20);
        outputField = new JTextField(20);
        outputField.setEditable(false);

        JButton countBtn = new JButton("Count Letters");
        JButton reverseBtn = new JButton("Reverse Letters");
        JButton removeBtn = new JButton("Remove Duplicates");

        countBtn.addActionListener(e -> {
            String text = inputField.getText();
            outputField.setText(String.valueOf(text.length()));
        });

        reverseBtn.addActionListener(e -> {
            String text = inputField.getText();
            outputField.setText(new StringBuilder(text).reverse().toString());
        });

        removeBtn.addActionListener(e -> {
            String text = inputField.getText();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (result.indexOf(String.valueOf(c)) == -1) { // If not already in result
                    result.append(c);
                }
            }

            outputField.setText(result.toString());
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Input:"));
        panel.add(inputField);
        panel.add(new JLabel("Output:"));
        panel.add(outputField);
        panel.add(countBtn);
        panel.add(reverseBtn);
        panel.add(removeBtn);

        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Problem62 frame = new Problem62();
            frame.setVisible(true);
        });
    }

    public static void centerFrameOnDesktop(Component f) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int xpos = (screenSize.width - f.getWidth()) / 2;
        int ypos = (screenSize.height - f.getHeight()) / 3;
        f.setLocation(xpos, ypos);
    }
}
