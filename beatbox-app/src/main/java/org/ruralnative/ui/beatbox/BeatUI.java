package org.ruralnative.ui.beatbox;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BeatUI {
    BeatboxController controller;
    ArrayList<JCheckBox> checkBoxList;
    JFrame frame;
    JPanel mainPanel;

    public BeatUI() {
        controller = new BeatboxController(this);
        checkBoxList = controller.instantiateCheckBoxList();
    }

    public void buildGUI() {
        frame = new JFrame("Cyber Beatbox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        checkBoxList = new ArrayList<>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        buttonBox.add(stop);

        JButton upTempo = new JButton("Up Tempo");
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Down Tempo");
        buttonBox.add(downTempo);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++) {
            nameBox.add(new Label(controller.getInstrumentName(i)));
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        frame.getContentPane().add(background);

        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(1);
        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);

        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkBoxList.add(c);
            mainPanel.add(c);
        }

        frame.setBounds(50, 50, 300, 300);
        frame.pack();
        frame.setVisible(true);
    }
}
