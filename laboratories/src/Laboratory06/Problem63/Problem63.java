package Laboratory06.Problem63;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Problem63 extends JFrame {
    private JTextField inputField;
    private JTextField outputField;
    private JComboBox<String> converterBox;

    private final Map<String, Function<Double, Double>> converters = new HashMap<>();

    public Problem63() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Unit Converter");
        setSize(500, 150);
        centerFrameOnDesktop(this);

        inputField = new JTextField(10);
        outputField = new JTextField(10);
        outputField.setEditable(false);

        String[] options = {
                "Miles to Kilometers", "Kilometers to Miles",
                "Pounds to Kilograms", "Kilograms to Pounds",
                "Gallons to Liters", "Liters to Gallons",
                "Fahrenheit to Celsius", "Celsius to Fahrenheit"
        };
        converterBox = new JComboBox<>(options);
        setupConverters();

        JButton convertBtn = new JButton("Convert");
        convertBtn.addActionListener(e -> convert());

        JPanel panel = new JPanel();
        panel.add(converterBox);
        panel.add(new JLabel("Input:"));
        panel.add(inputField);
        panel.add(new JLabel("Output:"));
        panel.add(outputField);
        panel.add(convertBtn);

        getContentPane().add(panel);
    }

    private void setupConverters() {
        converters.put("Miles to Kilometers", val -> val * 1.60934);
        converters.put("Kilometers to Miles", val -> val / 1.60934);
        converters.put("Pounds to Kilograms", val -> val * 0.453592);
        converters.put("Kilograms to Pounds", val -> val / 0.453592);
        converters.put("Gallons to Liters", val -> val * 3.78541);
        converters.put("Liters to Gallons", val -> val / 3.78541);
        converters.put("Fahrenheit to Celsius", val -> (val - 32) * 5 / 9);
        converters.put("Celsius to Fahrenheit", val -> val * 9 / 5 + 32);
    }

    private void convert() {
        try {
            double input = Double.parseDouble(inputField.getText());
            String selected = (String) converterBox.getSelectedItem();
            double result = converters.get(selected).apply(input);
            outputField.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            outputField.setText("Invalid");
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
