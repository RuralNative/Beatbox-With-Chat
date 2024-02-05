package org.ruralnative.ui.beatbox;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BeatboxView {
    BeatboxController controller;
    ArrayList<JCheckBox> checkBoxList;
    JFrame frame;
    JPanel mainPanel;
    JButton start;
    JButton stop;
    JButton upTempo;
    JButton downTempo;

    public BeatboxView() {
        controller = new BeatboxController(this);
        checkBoxList = controller.instantiateCheckBoxList();
        buildGUI();
    }

    public void buildGUI() {
        frame = new JFrame("Cyber Beatbox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        checkBoxList = new ArrayList<>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        start = new JButton("Start");
        start.addActionListener(action -> controller.handleStartButton());
        buttonBox.add(start);

        stop = new JButton("Stop");
        stop.addActionListener(action -> controller.handleStopButton());
        buttonBox.add(stop);

        upTempo = new JButton("Up Tempo");
        upTempo.addActionListener(action -> controller.handleUpTempoButton());
        buttonBox.add(upTempo);

        downTempo = new JButton("Down Tempo");
        downTempo.addActionListener(action -> controller.handleDownTempoButton());
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
