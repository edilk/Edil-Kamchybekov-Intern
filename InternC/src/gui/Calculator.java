package gui;

import operations.Operations;
import operations.PrintToLabel;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator extends JFrame {

    private JTextField textField;
    private JLabel result;

    public Calculator() {
        super("Calculator");
        setSize(new Dimension(500, 500));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        init();
        setResizable(false);
        setVisible(true);
    }

    private void init() {

        textField = new JTextField();
        textField.setBounds(25, 15, 435, 30);
        Font font = textField.getFont().deriveFont(16f);
        textField.setFont(font);
        textField.setMargin(new Insets(5, 5, 5, 5));
        add(textField);

        createResultLabel();
        createButtons();
    }

    private void createResultLabel() {
        result = new JLabel();
        result.setBounds(25, 55, 435, 220);
        add(result);
    }

    private void createButtons() {

        JButton oneButton = new JButton("1");
        oneButton.setBounds(25, 275, 100, 25);
        oneButton.addActionListener(e -> textField.setText(textField.getText() + "1"));
        add(oneButton);

        JButton twoButton = new JButton("2");
        twoButton.setBounds(135, 275, 100, 25);
        twoButton.addActionListener(e -> textField.setText(textField.getText() + "2"));
        add(twoButton);

        JButton threeButton = new JButton("3");
        threeButton.setBounds(245, 275, 100, 25);
        threeButton.addActionListener(e -> textField.setText(textField.getText() + "3"));
        add(threeButton);

        JButton divideButton = new JButton("/");
        divideButton.setBounds(355, 275, 100, 25);
        divideButton.addActionListener(e -> textField.setText(textField.getText() + "/"));
        add(divideButton);

        JButton fourButton = new JButton("4");
        fourButton.setBounds(25, 310, 100, 25);
        fourButton.addActionListener(e -> textField.setText(textField.getText() + "4"));
        add(fourButton);

        JButton fiveButton = new JButton("5");
        fiveButton.setBounds(135, 310, 100, 25);
        fiveButton.addActionListener(e -> textField.setText(textField.getText() + "5"));
        add(fiveButton);

        JButton sixButton = new JButton("6");
        sixButton.setBounds(245, 310, 100, 25);
        sixButton.addActionListener(e -> textField.setText(textField.getText() + "6"));
        add(sixButton);

        JButton multiplyButton = new JButton("*");
        multiplyButton.setBounds(355, 310, 100, 25);
        multiplyButton.addActionListener(e -> textField.setText(textField.getText() + "*"));
        add(multiplyButton);

        JButton sevenButton = new JButton("7");
        sevenButton.setBounds(25, 345, 100, 25);
        sevenButton.addActionListener(e -> textField.setText(textField.getText() + "7"));
        add(sevenButton);

        JButton eightButton = new JButton("8");
        eightButton.setBounds(135, 345, 100, 25);
        eightButton.addActionListener(e -> textField.setText(textField.getText() + "8"));
        add(eightButton);

        JButton nineButton = new JButton("9");
        nineButton.setBounds(245, 345, 100, 25);
        nineButton.addActionListener(e -> textField.setText(textField.getText() + "9"));
        add(nineButton);

        JButton minusButton = new JButton("-");
        minusButton.setBounds(355, 345, 100, 25);
        minusButton.addActionListener(e -> textField.setText(textField.getText() + "-"));
        add(minusButton);

        JButton dotButton = new JButton(".");
        dotButton.setBounds(25, 380, 100, 25);
        dotButton.addActionListener(e -> textField.setText(textField.getText() + "."));
        add(dotButton);

        JButton zeroButton = new JButton("0");
        zeroButton.setBounds(135, 380, 100, 25);
        zeroButton.addActionListener(e -> textField.setText(textField.getText() + "0"));
        add(zeroButton);

        JButton commaButton = new JButton(",");
        commaButton.setBounds(245, 380, 100, 25);
        commaButton.addActionListener(e -> textField.setText(textField.getText() + ","));
        add(commaButton);

        JButton plusButton = new JButton("+");
        plusButton.setBounds(355, 380, 100, 25);
        plusButton.addActionListener(e -> textField.setText(textField.getText() + "+"));
        add(plusButton);

        JButton openButton = new JButton("(");
        openButton.setBounds(25, 415, 100, 25);
        openButton.addActionListener(e -> textField.setText(textField.getText() + "("));
        add(openButton);

        JButton assignButton = new JButton("=");
        assignButton.setBounds(135, 415, 210, 25);
        add(assignButton);

        assignButton.addActionListener(e -> {

            if (textField.getText().length() == 0) {
                result.setText("Empty text field! Please fill the field!");
            }
            String[] num = textField.getText().split("[*\\-+/]");
            double x = Double.parseDouble(num[0]);
            double y = Double.parseDouble(num[1]);

            Pattern pattern = Pattern.compile("[/*\\-+]");
            Matcher matcher = pattern.matcher(textField.getText());
            String oper = "";
            if (matcher.find()) {
                oper = matcher.group();
            }

            Operations operations = new Operations();
            PrintToLabel label = new PrintToLabel();
            switch (oper) {
                case "/":
                    result.setText(label.printDivision(x, y));
                    textField.setText(textField.getText() + "=" + operations.divide(x, y));
                    break;
                case "*":
                    result.setText(label.printMultiplication(x, y));
                    textField.setText(textField.getText() + "=" + operations.multiply(x, y));
                    break;
                case "-":
                    result.setText(label.printAdditionAndSubtraction(x, y, "-"));
                    textField.setText(textField.getText() + "=" + operations.subtract(x, y));
                    break;
                case "+":
                    result.setText(label.printAdditionAndSubtraction(x, y, "+"));
                    textField.setText(textField.getText() + "=" + operations.add(x, y));
                    break;
                default:
                    result.setText("Error!");
            }
        });

        JButton closeButton = new JButton(")");
        closeButton.setBounds(355, 415, 100, 25);
        closeButton.addActionListener(e -> textField.setText(textField.getText() + ")"));
        add(closeButton);
    }

}
