/**
 * Created by kieran on 09/03/16.
 */
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class lotto extends JFrame {

    private JPanel buttonPanel;

    private JButton topButton, bottomButton;

    private JPanel labelPanel;

    private JTextField one, two, three, four, five, six;

    private JTextField[] labels;

    public lotto(){
        buttonPanel = new JPanel(new GridLayout(2, 1));
        buttonPanel.setBorder(new LineBorder(Color.BLACK, 2));
        buttonPanel.add(topButton = new JButton("Quick Pick Numbers", new ImageIcon("images/lotto.png")));
        buttonPanel.add(bottomButton = new JButton("Reset Numbers", new ImageIcon( "images/lotto.png")));
        topButton.setMnemonic('Q');
        bottomButton.setMnemonic('R');
        topButton.setToolTipText("Gives Random Numbers");
        bottomButton.setToolTipText("Resets numers to Zero");
        topButton.setHorizontalTextPosition(JButton.CENTER);
        topButton.setVerticalTextPosition(JButton.BOTTOM);
        bottomButton.setHorizontalTextPosition(JButton.CENTER);
        bottomButton.setVerticalTextPosition(JButton.BOTTOM);
        topButton.setBackground(Color.WHITE);
        bottomButton.setBackground(Color.WHITE);

        labelPanel = new JPanel(new GridLayout(6, 1));
        labelPanel.setBorder(new LineBorder(Color.BLACK, 2));
        labelPanel.add(one = new JTextField("0", 2));
        labelPanel.add(two = new JTextField("0", 2));
        labelPanel.add(three = new JTextField("0", 2));
        labelPanel.add(four = new JTextField("0", 2));
        labelPanel.add(five = new JTextField("0", 2));
        labelPanel.add(six = new JTextField("0", 2));

        labels = new JTextField[]{
            one, two, three, four, five, six
        };

        for(int i = 0;i < labels.length;i++){
            labels[i].setFont(new Font("Sans Serif", Font.BOLD, 20));
            labels[i].setBackground(Color.WHITE);
            labels[i].setBorder(new LineBorder(Color.black, 4));
            labels[i].setEditable(false);
            labels[i].setHorizontalAlignment(JTextField.CENTER);

        }

        this.add(buttonPanel, BorderLayout.WEST);
        this.add(labelPanel, BorderLayout.EAST);

        final Random random = new Random();

        topButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int i = 0; i < labels.length; i++){
                    int a = random.nextInt(47);
                    labels[i].setText("" + a);
                }
            }
        });

        bottomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(int i = 0; i < labels.length; i++){
                    labels[i].setText("0");
                }
            }
        });

    }

    public static void main(String [] args){
        lotto frame = new lotto();
        frame.pack();
        frame.setTitle("Lotto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
