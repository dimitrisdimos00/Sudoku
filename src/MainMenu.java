import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MainMenu extends JFrame {

    private JPanel firstPanel;
    private JLabel UserNameLabel;
    private JTextField UserNameTextField;

    private JPanel secondPanel;
    private ButtonGroup group;
    private JRadioButton greekRadioButton;
    private JRadioButton englishRadioButton;

    private JButton startButton;

    public JRadioButton getGreekRadioButton() {
        return greekRadioButton;
    }
    public JRadioButton getEnglishRadioButton() {
        return englishRadioButton;
    }
    public JTextField getUserNameTextField() {
        return UserNameTextField;
    }
    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    MainMenu() {
        MenuStart();
    }

    private void MenuStart() {
        setTitle("Sudoku");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        firstPanel = new JPanel(new GridLayout(1,2));
        UserNameLabel = new JLabel("(Υποχρεωτικό) Ψευδώνυμο / (Required) UserName: ");
        DocumentListener listener = new DocumentListener(this);
        UserNameTextField = new JTextField("");
        UserNameTextField.getDocument().addDocumentListener(listener);
        firstPanel.add(UserNameLabel);
        firstPanel.add(UserNameTextField);

        add(firstPanel, BorderLayout.PAGE_START);
        pack();

            TitledBorder border = BorderFactory.createTitledBorder("Επέλεξε γλώσσα / Choose Language: ");
            secondPanel = new JPanel(new GridLayout(1,2));
            secondPanel.setBorder(border);

            group = new ButtonGroup();
            greekRadioButton = new JRadioButton("Ελληνικά");
            greekRadioButton.setSelected(true);
            englishRadioButton = new JRadioButton("English");
            group.add(greekRadioButton);
            group.add(englishRadioButton);

            secondPanel.add(greekRadioButton);
            secondPanel.add(englishRadioButton);

            add(secondPanel, BorderLayout.CENTER);
            pack();

                MainMenuStartButtonActionListener actionListener = new MainMenuStartButtonActionListener(this);
                startButton = new JButton("Ξεκίνα / Start");
                startButton.setEnabled(false);
                startButton.addActionListener(actionListener);
                add(startButton, BorderLayout.PAGE_END);

        setSize(600,130);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /*public static void main(String[] args) {
        new MainMenu();
    }*/
}
