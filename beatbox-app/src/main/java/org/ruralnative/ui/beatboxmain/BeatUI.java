package org.ruralnative.ui.beatboxmain;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BeatUI {
    JPanel mainPanel;
    ArrayList<JCheckBox> checkBoxList;
    Sequencer player;
    Sequence sequence;
    Track track;
    JFrame frame;

    String[] instrumentNames = {
            "Bass Drum",
            "Closed Hi-hat",
            "Open Hi-hat",
            "Acoustic Snare",
            "Crash Cymbal",
            "Hand Clap",
            "High Tom",
            "High Bongo",
            "Maracas",
            "Whistle",
            "Low Conga",
            "Cowbell",
            "Vibraslap",
            "Low-mid Tom",
            "High Agogo",
            "Open Hi Conga"
    };
    int[] instruments = {
            35,
            42,
            46,
            38,
            49,
            39,
            50,
            60,
            70,
            72,
            64,
            56,
            58,
            47,
            67,
            63
    };

    public void buildGUI() {
        frame = new JFrame("Cyber Beatbox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        checkBoxList = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        start.addActionListener(new MyStopListener());
        buttonBox.add(start);

        JButton upTempo = new JButton("Up Tempo");
        start.addActionListener(new MyUpTempoListener());
        buttonBox.add(start);

        JButton downTempo = new JButton("Down Tempo");
        start.addActionListener(new MyDownTempoListener());
        buttonBox.add(start);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++) {
            nameBox.add(new Label(instrumentNames[i]));
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

        setupMidi();

        frame.setBounds(50, 50, 300, 300);
        frame.pack();
        frame.setVisible(true);
    }

    public void setupMidi() {
        try {
            player = MidiSystem.getSequencer();
            player.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            player.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
