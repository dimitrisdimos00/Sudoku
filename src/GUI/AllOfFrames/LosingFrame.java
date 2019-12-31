package GUI.AllOfFrames;

import GUI.AllOfListeners.LosingButtonActionListener;
import GUI.AllOfListeners.WinningButtonActionListener;

import javax.swing.*;
import java.awt.*;

public class LosingFrame extends JFrame {

    private SudokuFrame aSudokuFrame;

    private String Title;
    private String message;
    private String ButtonName;

    private JLabel losingLabel;
    private JButton losingButton;

    public LosingFrame(SudokuFrame aSudokuFrame) {

        this.aSudokuFrame = aSudokuFrame;

        Title = aSudokuFrame.getaSecondMenu().isFromGreekMenu() ? "Μόλις Έχασες" : "You Lost" ;
        message = aSudokuFrame.getaSecondMenu().isFromGreekMenu() ? "Δυστηχώς μόλις έχασες!" : "Unfortunately You Lost!" ;
        ButtonName = aSudokuFrame.getaSecondMenu().isFromGreekMenu() ? "Πάτα με για να κλέισει το παιχνίδι!" : "Click me to close the application" ;

        this.makeFrame();
    }

    void makeFrame() {
        setTitle(Title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        losingLabel = new JLabel(message);

        LosingButtonActionListener theActionListener = new LosingButtonActionListener(this);
        losingButton = new JButton(ButtonName);
        losingButton.addActionListener(theActionListener);

        FlowLayout layout = new FlowLayout();

        setLayout(layout);
        add(losingLabel);
        add(losingButton);

        setSize(300,100);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
