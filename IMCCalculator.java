import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IMCCalculator extends JFrame {
    private JTextField weightField;
    private JTextField heightField;
    private JLabel resultLabel;

    public IMCCalculator() {
        setTitle("Calculadora de IMC");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        JLabel weightLabel = new JLabel("Peso (kg):");
        weightField = new JTextField();
        JLabel heightLabel = new JLabel("Altura (m):");
        heightField = new JTextField();

        JButton calculateButton = new JButton("Calcular IMC");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateIMC();
            }
        });

        resultLabel = new JLabel();

        add(weightLabel);
        add(weightField);
        add(heightLabel);
        add(heightField);
        add(new JLabel());
        add(calculateButton);
        add(new JLabel("IMC Resultado:"));
        add(resultLabel);

        setVisible(true);
    }

    private void calculateIMC() {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());
            double bmi = weight / (height * height);
            String classification = getIMCClassification(bmi);
            resultLabel.setText(String.format("%.2f - %s", bmi, classification));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa números válidos para peso y altura.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String getIMCClassification(double bmi) {
        if (bmi < 18.5) {
            return "Bajo peso";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Sobrepeso";
        } else {
            return "Obeso";
        }
    }

    public static void main(String[] args) {
        new IMCCalculator();
    }
}
