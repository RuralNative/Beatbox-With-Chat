package org.ruralnative;

import org.ruralnative.ui.MusicTest1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BeatFrame implements ActionListener {

    private JFrame frame;
    private JButton button;

    public void createFrame() {
        frame = new JFrame();
        createButton();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(button);

        frame.setSize(300, 300);

        frame.setVisible(true);
    }

    private void createButton() {
        button = new JButton("Click Me");
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button.setText("I was CLICKED!!");
        MusicTest1 test = new MusicTest1();
        test.play();
    }
}
