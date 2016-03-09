import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

// PizzaMenu IS-A JFrame ==> Inheritance
public class PizzaMenu extends JFrame{
    // Instance Variables go here (properties of our JFrame)...
    // It has a radioButtonPanel with 3 JRadioButtons,
    private JPanel radioButtonPanel;
    private JRadioButton smallButton, mediumButton, largeButton;
    private ButtonGroup btg;

    // a checkBoxPanel with 2 JCheckBoxes, and
    private JPanel checkBoxPanel;
    private JCheckBox pepperoniCheckBox, anchoviesCheckBox;

    // a JButton...
    private JButton jbtTotal;

    // And a pricePanel with a JLabel and a JTextField.
    private JPanel pricePanel;
    private JLabel priceLabel;
    private JTextField priceTextField;

    // Constructor - SetLayout & Add Components here...
    public PizzaMenu(){
        // Set up radioButtonPanel with GridLayout 3 Rows, 1 Column
        radioButtonPanel = new JPanel(new GridLayout(3,1));
        // Add 3 JRadioButtons, and...
        radioButtonPanel.add(smallButton = new JRadioButton("Small", true));
        radioButtonPanel.add(mediumButton = new JRadioButton("Medium"));
        radioButtonPanel.add(largeButton = new JRadioButton("Large"));
        btg = new ButtonGroup();
        btg.add(smallButton);
        btg.add(mediumButton);
        btg.add(largeButton);
        // Put a TitledBorder around it.
        radioButtonPanel.setBorder(new TitledBorder("Size"));

        // Set up checkBoxPanel	with GridLayout 2 Rows, 1 Column
        checkBoxPanel = new JPanel(new GridLayout(2,1));
        // Add 2 JCheckBoxes, and...
        checkBoxPanel.add(pepperoniCheckBox = new JCheckBox("Pepperoni"));
        checkBoxPanel.add(anchoviesCheckBox = new JCheckBox("Anchovies"));
        // Put a TitledBorder around it.
        checkBoxPanel.setBorder(new TitledBorder("Extras"));

        // Set up jbtTotal JButton
        jbtTotal = new JButton("TOTAL", new ImageIcon("image/euro.jpg"));
        // Center the icon and text and place the text under the icon
        jbtTotal.setHorizontalTextPosition(JButton.CENTER);
        jbtTotal.setVerticalTextPosition(JButton.TOP);
        jbtTotal.setFont(new Font("Helvetica", Font.BOLD, 30));
        jbtTotal.setBackground(Color.LIGHT_GRAY);
        jbtTotal.setMnemonic('T');

        // Set up pricePanel - defaults to FlowLayout
        pricePanel = new JPanel();
        // Add a JLabel and a JTextField, and...
        pricePanel.add(priceLabel = new JLabel("Your Price:"));
        pricePanel.add(priceTextField = new JTextField(10));
        // Put a LineBorder around it.
        pricePanel.setBorder(new LineBorder(Color.BLUE, 4));

        this.add(radioButtonPanel,BorderLayout.WEST);
        this.add(checkBoxPanel,BorderLayout.CENTER);
        this.add(jbtTotal,BorderLayout.EAST);
        this.add(pricePanel,BorderLayout.SOUTH);

        // Register listener with jbtTotal and extrasButton
        ListenerClass listener = new ListenerClass();
        jbtTotal.addActionListener(listener);
    }
    // Main method - Construct frame object here...
    // ... and set it up
    public static void main(String[] args){
        // CONSTRUCT a PizzaMenu object called frame, and display it
        PizzaMenu frame = new PizzaMenu();
        frame.pack();
        frame.setTitle("PIZZA MENU");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }

    // INNER CLASS LISTENER
    private class ListenerClass implements ActionListener{
        double price=0.0;
        public void actionPerformed(ActionEvent e){
            // Determine which JRadioButton was selected - only one can be so if else...
            if(smallButton.isSelected())	// OR smallButton.isSelected() == true
                price += 5;						// OR price = price + 5;
            else if(mediumButton.isSelected())
                price += 8;
            else if(largeButton.isSelected())
                price += 10;
            // Determine which JCheckBox was selected - more than one can be so if ...
            if(pepperoniCheckBox.isSelected())
                price += 1.50;
            if(anchoviesCheckBox.isSelected())
                price += 1;

            // setText() in priceTextField to price
            priceTextField.setText("" + price);
            price=0.0;
        }
    }
}























