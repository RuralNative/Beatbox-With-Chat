package org.ruralnative.ui;

import javax.swing.*;

public class BeatboxView extends JFrame {

    private JButton button;

    BeatboxView() {
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
