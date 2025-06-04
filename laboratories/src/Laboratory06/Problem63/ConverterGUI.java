package Laboratory06.Problem63;

import javax.swing.*;

public class ConverterGUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Unit Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        String[] conversions = {
                "Miles to Kilometers", "Kilometers to Miles",
                "Pounds to Kilograms", "Kilograms to Pounds",
                "Gallons to Liters", "Liters to Gallons",
                "Fahrenheit to Celsius", "Celsius to Fahrenheit"
        };

        JComboBox<String> comboBox = new JComboBox<>(conversions);
        JTextField input = new JTextField(10);
        JTextField output = new JTextField(10);
        output.setEditable(false);
        JButton convertBtn = new JButton("Convert");

        JPanel panel = new JPanel();
        panel.add(comboBox);
        panel.add(new JLabel("Input:"));
        panel.add(input);
        panel.add(new JLabel("Output:"));
        panel.add(output);
        panel.add(convertBtn);

        convertBtn.addActionListener(e -> {
            try {
                double val = Double.parseDouble(input.getText());
                String type = (String) comboBox.getSelectedItem();
                double result = switch (type) {
                    case "Miles to Kilometers" -> val * 1.60934;
                    case "Kilometers to Miles" -> val / 1.60934;
                    case "Pounds to Kilograms" -> val * 0.453592;
                    case "Kilograms to Pounds" -> val / 0.453592;
                    case "Gallons to Liters" -> val * 3.78541;
                    case "Liters to Gallons" -> val / 3.78541;
                    case "Fahrenheit to Celsius" -> (val - 32) * 5 / 9;
                    case "Celsius to Fahrenheit" -> val * 9 / 5 + 32;
                    default -> 0;
                };
                output.setText(String.format("%.2f", result));
            } catch (NumberFormatException ex) {
                output.setText("Invalid input");
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
