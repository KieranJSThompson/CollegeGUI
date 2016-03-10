/**
 * Created by kieran on 08/03/16.
 */
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dvdplayer extends JFrame {

    private JPanel dvdTrayPanel;
    private JLabel dvdTrayLabel;

    private JPanel infoPanel;
    private JLabel dvdInfo;

    private int currentIndex = 0;

    private JPanel buttonPanel;
    private JButton close, open, play, stop, forward, back;

    private ButtonGroup btnGroup;

    info[] infoBank = new info[]{
            new info("Tropic Thunder", 2009, "2 hrs 45 mins"),
            new info("ZooLander", 1999, "1hr 30 mins"),
            new info("Lord of the Rings: The Two Towers", 2001, "4hrs 25 mins")


    };

    public void updateDVD() {
        currentIndex++;
    }

    public dvdplayer() {
        dvdTrayPanel = new JPanel(new GridLayout(1, 1));
        dvdTrayPanel.add(dvdTrayLabel = new JLabel("PLACE DVD HERE"));

        infoPanel = new JPanel(new GridLayout(2, 3));
        infoPanel.add(dvdInfo = new JLabel(infoBank[currentIndex].toString()));

        buttonPanel = new JPanel(new GridLayout(1, 4, 1, 1));
        buttonPanel.add(close = new JButton(new ImageIcon("images/close.png")));
        buttonPanel.add(open = new JButton(new ImageIcon("images/open.png")));
        buttonPanel.add(play = new JButton(new ImageIcon("images/play.png")));
        buttonPanel.add(stop = new JButton(new ImageIcon("images/stop.png")));
        buttonPanel.add(forward = new JButton(new ImageIcon("images/forward.png")));
        buttonPanel.add(back = new JButton(new ImageIcon("images/back.png")));


        this.add(dvdTrayLabel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(infoPanel, BorderLayout.CENTER);

        forward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(currentIndex == (infoBank.length - 1)){
                    currentIndex = 0;
                    dvdInfo.setText(infoBank[currentIndex].toString());
                }
                else {
                    updateDVD();
                    dvdInfo.setText(infoBank[currentIndex].toString());
                }

            }
        });

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dvdInfo.setText("PUT DVD IN HERE!");
            }
        });

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dvdInfo.setText(null);
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(currentIndex == 0){
                    dvdInfo.setText(infoBank[currentIndex += infoBank.length].toString());

                }
                else {
                    dvdInfo.setText(infoBank[(currentIndex - 1)].toString());
                }
            }
        });

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dvdInfo.setText(infoBank[currentIndex].toString());

            }
        });

        }





    public static void main(String[] args) {
        dvdplayer frame = new dvdplayer();
        frame.pack();
        frame.setTitle("***DVD PLAYER***");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
