package org.ruralnative.ui.beatbox;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BeatboxView {
    BeatboxController controller;
    ArrayList<JCheckBox> checkBoxList;
    JFrame frame;
    JPanel backgroundPanel;
    Box buttonBox;
    Box nameBox;
    JPanel mainPanel;
    JButton start;
    JButton stop;
    JButton upTempo;
    JButton downTempo;

    public BeatboxView() {
        controller = new BeatboxController();
        checkBoxList = controller.instantiateCheckBoxList();
        buildGUI();
    }

    public void buildGUI() {
        frame = new JFrame("Cyber Beatbox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();

        backgroundPanel = new JPanel(layout);
        backgroundPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setUpLabels();
        backgroundPanel.add(BorderLayout.WEST, nameBox);
        setUpMainPanel();
        backgroundPanel.add(BorderLayout.CENTER, mainPanel);
        setUpButtons();
        backgroundPanel.add(BorderLayout.EAST, buttonBox);
        frame.getContentPane().add(backgroundPanel);

        frame.setBounds(50, 50, 300, 300);
        frame.pack();
        frame.setVisible(true);
    }

    private void setUpButtons() {
        buttonBox = new Box(BoxLayout.Y_AXIS);

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

        serializeBeat = new JButton("Save Beat");
        serializeBeat.addActionListener(action -> controller.handleSerializeBeatButton());
        buttonBox.add(serializeBeat);

        restoreBeat = new JButton("Restore Beat");
        restoreBeat.addActionListener(action -> controller.handleRestoreBeatButton());
        buttonBox.add(restoreBeat);
    }

    private void setUpLabels() {
        nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++) {
            nameBox.add(new Label(controller.getInstrumentName(i)));
        }
    }

    private void setUpMainPanel() {
        GridLayout checkBoxGrid = new GridLayout(16, 16);
        checkBoxGrid.setVgap(1);
        checkBoxGrid.setHgap(1);

        mainPanel = new JPanel(checkBoxGrid);
        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkBoxList.add(c);
            mainPanel.add(c);
        }
    }
}
