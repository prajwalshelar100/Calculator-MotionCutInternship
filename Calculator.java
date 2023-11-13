package calculator;
/**
 * Calculator Program
 * 
 * This Java program implements a basic calculator using the Swing framework.
 * It allows users to perform arithmetic operations and provides a graphical interface.
 * 
 * Author: [Your Name]
 * Date: [Current Date]
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    // GUI components
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    // Font for the textfield
    Font myFont = new Font("SansSerif", Font.BOLD, 30);

    // Variables for arithmetic operations
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    /**
     * Constructor for the Calculator class.
     * Initializes the GUI components and sets up the layout.
     */
    Calculator() {

        // Create the main frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        // Create and configure the textfield
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        // Create operator buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        // Initialize the array of function buttons
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        // Configure function buttons
        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        // Create number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        // Set positions for special function buttons
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        // Create and configure the panel for number and operator buttons
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Add components to the frame
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    /**
     * The main method creates an instance of the Calculator class.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    /**
     * ActionListener implementation for handling button clicks.
     * 
     * @param e ActionEvent representing the button click.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // Handle number buttons
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        // Handle decimal point button
        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }

        // Handle arithmetic operation buttons
        if (e.getSource() == addButton || e.getSource() == subButton ||
            e.getSource() == mulButton || e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = e.getActionCommand().charAt(0);
            textfield.setText("");
        }

        // Handle equals button
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            textfield.setText(String.valueOf(result));
            num1 = result;
        }

        // Handle clear button
        if (e.getSource() == clrButton) {
            textfield.setText("");
        }

        // Handle delete button
        if (e.getSource() == delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }

        // Handle negation button
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }
    }
}
