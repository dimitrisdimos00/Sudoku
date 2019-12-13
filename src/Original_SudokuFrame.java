import javax.swing.*;
import java.awt.*;

public class Original_SudokuFrame extends JFrame {

    private JPanel firstPanel;
    private JTextField[][] theField;

    Original_SudokuFrame() {
        makeFrame();
    }

    private void makeFrame() {
        setTitle("Original Sudoku");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        firstPanel = new JPanel(new GridLayout(9,9));
        theField = new JTextField[9][9];
        for (int i=0; i<9 ;i++) {
            for (int j=0;j<9;j++) {
                theField[i][j] = new JTextField("");
                theField[i][j].setHorizontalAlignment(JTextField.CENTER);
                theField[i][j].setFont(new Font("Courier", Font.BOLD,30));
                firstPanel.add(theField[i][j]);
            }
        }

        add(firstPanel);

        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
