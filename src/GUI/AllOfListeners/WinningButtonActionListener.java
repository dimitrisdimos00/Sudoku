package GUI.AllOfListeners;

import GUI.AllOfFrames.WinningFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

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
