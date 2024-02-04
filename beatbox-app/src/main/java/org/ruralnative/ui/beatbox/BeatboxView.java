package org.ruralnative.ui.beatbox;

import javax.swing.*;

class BeatboxView extends JFrame {

    private JButton button;

    public BeatboxView() {
        super("Beat Box App");

        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    protected JButton getButton() {
        return this.button;
    }
}
