package GUI.AllOfListeners;

import GUI.AllOfFrames.WinningFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Αυτή η κλάση οφείλεται για το κλείσιμο της εφαρμογής όταν πατηθεί τo κουμπή απο την κλάση WinningFrame.
 *
 * @author Γιώργος Τσιφούτης
 */
public class WinningButtonActionListener implements ActionListener {

    private WinningFrame aWinningFrame;

    public WinningButtonActionListener(WinningFrame aWinningFrame) {
        this.aWinningFrame = aWinningFrame;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        aWinningFrame.dispatchEvent(new WindowEvent(aWinningFrame, WindowEvent.WINDOW_CLOSING));
    }
}
