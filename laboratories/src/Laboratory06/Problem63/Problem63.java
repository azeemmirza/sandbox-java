package Laboratory06.Problem63;

import javax.swing.*;
import java.awt.*;

public class Problem63 extends JFrame {
    private JTextField inputField;
    private JTextField outputField;
    private JComboBox<String> converterBox;

    public Problem63() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Unit Converter");
        setSize(500, 150);
        centerFrameOnDesktop(this);

        // Initialize fields
        inputField = new JTextField(10);
        outputField = new JTextField(10);
        outputField.setEditable(false);

        // Dropdown options
        String[] options = {
                "Miles to Kilometers", "Kilometers to Miles",
                "Pounds to Kilograms", "Kilograms to Pounds",
                "Gallons to Liters", "Liters to Gallons",
                "Fahrenheit to Celsius", "Celsius to Fahrenheit"
        };

        converterBox = new JComboBox<>(options);

        JButton convertBtn = new JButton("Convert");
        convertBtn.addActionListener(e -> convert());

        // Build GUI panel
        JPanel panel = new JPanel();
        panel.add(converterBox);
        panel.add(new JLabel("Input:"));
        panel.add(inputField);
        panel.add(new JLabel("Output:"));
        panel.add(outputField);
        panel.add(convertBtn);

        getContentPane().add(panel);
    }

    private void convert() {
        String selected = (String) converterBox.getSelectedItem();
        try {
            double input = Double.parseDouble(inputField.getText());
            double result;

            switch (selected) {
                case "Miles to Kilometers":
                    result = input * 1.60934;
                    break;
                case "Kilometers to Miles":
                    result = input / 1.60934;
                    break;
                case "Pounds to Kilograms":
                    result = input * 0.453592;
                    break;
                case "Kilograms to Pounds":
                    result = input / 0.453592;
                    break;
                case "Gallons to Liters":
                    result = input * 3.78541;
                    break;
                case "Liters to Gallons":
                    result = input / 3.78541;
                    break;
                case "Fahrenheit to Celsius":
                    result = (input - 32) * 5 / 9;
                    break;
                case "Celsius to Fahrenheit":
                    result = input * 9 / 5 + 32;
                    break;
                default:
                    outputField.setText("Unknown");
                    return;
            }

            outputField.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            outputField.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Problem63 frame = new Problem63();
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