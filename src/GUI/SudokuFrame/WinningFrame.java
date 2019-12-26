package GUI.SudokuFrame;

import GUI.AllOfListeners.WinningButtonActionListener;

import javax.swing.*;
import java.awt.*;

public class WinningFrame extends JFrame {

    private SudokuFrame aSudokuFrame;

    private String Title;
    private String message;
    private String ButtonName;

    private JLabel winningLabel;
    private JButton winningButton;

    public WinningFrame(SudokuFrame aSudokuFrame) {

        this.aSudokuFrame = aSudokuFrame;

        Title = aSudokuFrame.getaSecondMenu().isFromGreekMenu() ? "Συγχαρητήρια" : "Congratulations" ;
        message = aSudokuFrame.getaSecondMenu().isFromGreekMenu() ? "Συγχαρητήρια μόλις κέρδισες!" : "Congratulations You Won!" ;
        ButtonName = aSudokuFrame.getaSecondMenu().isFromGreekMenu() ? "Πάτα με για να κλέισει το παιχνίδι!" : "Click me to close the application" ;

        this.makeFrame();
    }

    void makeFrame() {
        setTitle(Title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        winningLabel = new JLabel(message);

        WinningButtonActionListener theActionListener = new WinningButtonActionListener(this);
        winningButton = new JButton(ButtonName);
        winningButton.addActionListener(theActionListener);

        FlowLayout layout = new FlowLayout();

        setLayout(layout);
        add(winningLabel);
        add(winningButton);

        setSize(300,100);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
