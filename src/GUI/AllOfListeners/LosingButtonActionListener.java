package GUI.AllOfListeners;

import GUI.AllOfFrames.LosingFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

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
