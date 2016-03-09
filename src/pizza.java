/**
 * Created by kieran on 08/03/16.
 */
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class pizza extends JFrame {
    private JPanel radioButtonPanel;
    private JRadioButton smallButton, mediumButton, largeButton;
    private ButtonGroup btng;

    private JPanel checkBoxPanel;
    private JCheckBox pepperoniCheckBox, anchoviesChecBox;

    private JButton jbtTotal;

    private JPanel pricePanel;
    private JLabel priceLabel;
    private JTextField priceTextField;

    public pizza(){
        radioButtonPanel = new JPanel(new GridLayout(3,1));
        radioButtonPanel.add(smallButton = new JRadioButton("small", true));
        radioButtonPanel.add(mediumButton = new JRadioButton("Medium"));
        radioButtonPanel.add(largeButton = new JRadioButton("Large"));
        btng = new ButtonGroup();
        btng.add(smallButton);
        btng.add(mediumButton);
        btng.add(largeButton);

        radioButtonPanel.setBorder(new TitledBorder("Size"));


        checkBoxPanel = new JPanel(new GridLayout(2,1));
        checkBoxPanel.add(pepperoniCheckBox = new JCheckBox("Pepperoni"));
        checkBoxPanel.add(anchoviesChecBox = new JCheckBox("Anchovies"));

        checkBoxPanel.setBorder(new TitledBorder("Extras"));

        jbtTotal = new JButton("Total");

        jbtTotal.setHorizontalTextPosition(JButton.CENTER);
        jbtTotal.setVerticalTextPosition(JButton.TOP);
        jbtTotal.setFont(new Font("Helvetica", Font.BOLD, 30));
        jbtTotal.setBackground(Color.lightGray);
        jbtTotal.setMnemonic('T');

        pricePanel = new JPanel();
        pricePanel.add(priceLabel = new JLabel("Your Price: "));
        pricePanel.add(priceTextField = new JTextField(10));

        pricePanel.setBorder(new LineBorder(Color.BLUE, 4));

        this.add(radioButtonPanel,BorderLayout.WEST);
        this.add(checkBoxPanel,BorderLayout.CENTER);
        this.add(pricePanel,BorderLayout.SOUTH);
        this.add(jbtTotal,BorderLayout.EAST);

        ListenerClass listener = new ListenerClass();
        jbtTotal.addActionListener(listener);
    }

    public static void main(String [] args) {
        pizza frame = new pizza();
        frame.pack();
        frame.setTitle("***Pizza Menu***");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
        private class ListenerClass implements ActionListener {
            double price = 0.0;
            public void actionPerformed(ActionEvent e){

            if(smallButton.isSelected())

            {
                price += 5;
            }

            else if(mediumButton.isSelected())

            {
                price += 8;
            }

            else if(largeButton.isSelected())

            {
                price += 10;
            }

            if(pepperoniCheckBox.isSelected())

            {
                price += 1.50;
            }

            if(anchoviesChecBox.isSelected())

            {
                price += 1.00;
            }

            priceTextField.setText(""+price);
            price=0.0;
        }
    }
}

