package GUI.AllOfListeners;

import GUI.AllOfFrames.LosingFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Αυτή η κλάση οφείλεται για το κλείσιμο της εφαρμογής όταν πατηθεί τo κουμπή απο την κλάση LosingFrame.
 *
 * @author Γιώργος Τσιφούτης
 */
public class LosingButtonActionListener implements ActionListener {

    private LosingFrame aLosingFrame;

    public LosingButtonActionListener(LosingFrame aLosingFrame) {
        this.aLosingFrame = aLosingFrame;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        aLosingFrame.dispatchEvent(new WindowEvent(aLosingFrame, WindowEvent.WINDOW_CLOSING));
    }
}
