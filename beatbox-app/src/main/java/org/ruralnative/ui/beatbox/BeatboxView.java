package org.ruralnative.ui.beatbox;

import javax.swing.*;

class BeatboxView extends JFrame {

    private JButton button;

    public BeatboxView() {
        super("Beat Box App");
        button = new JButton("Click Me");
        add(button);

        setSize(300, 300);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    protected JButton getButton() {
        return this.button;
    }
}
