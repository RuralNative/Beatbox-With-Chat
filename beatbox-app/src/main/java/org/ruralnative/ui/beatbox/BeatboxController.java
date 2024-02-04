package org.ruralnative.ui.beatbox;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BeatboxController {
    private BeatboxModel model;
    private BeatUI view;

    protected BeatboxController() {
        this.model = new BeatboxModel();
    }

    protected ArrayList<JCheckBox> instantiateCheckBoxList() {
        model.setCheckBoxList(new ArrayList<JCheckBox>());
        return model.getCheckBoxList();
    }

    protected String getInstrumentName(int index) {
        return model.getInstrumentNames()[index];
    }

    protected int getInstrument(int index) {
        return model.getInstrumentList()[index];
    }

    public void setupMidi() {
        try {
            model.setPlayer(MidiSystem.getSequencer());
            model.getPlayer().open();
            model.setSequence(new Sequence(Sequence.PPQ, 4));
            model.setTrack(model.getSequence().createTrack());
            model.getPlayer().setTempoInBPM(120);
        } catch (Exception e) {
            System.out.println("Midi Setup FAILED");
            System.out.println("Check setupMidi()");
        }
    }

    public void buildTrackAndStart() {
        int[] trackList = null;

        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for (int i = 0; i < 16; i++) {
            trackList = new int[16];

            int key = controller.getInstrument(i);

            for (int j = 0; j < 16; j++) {
                JCheckBox jc = (JCheckBox) checkBoxList.get(j + (16*i));
                if (jc.isSelected()) {
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                }
            }
            makeTracks(trackList);

            // Used for ControllerListener
            track.add(makeEvent(176, 1, 127, 0, 16));
        }

        track.add(makeEvent(192, 9, 1, 0, 15));
        try {
            player.setSequence(sequence);
            player.setLoopCount(player.LOOP_CONTINUOUSLY);
            player.start();
            player.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class MyStartListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            buildTrackAndStart();
        }
    }

    public class MyStopListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            player.stop();
        }
    }

    public class MyUpTempoListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            float tempoFactor = player.getTempoFactor();
            player.setTempoFactor((float) (tempoFactor * 1.03));
        }
    }

    public class MyDownTempoListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            float tempoFactor = player.getTempoFactor();
            player.setTempoFactor((float) (tempoFactor * 0.97));
        }
    }

    // Creates a Track for a Single
    public void makeTracks(int[] list) {
        for (int i = 0; i < 16; i++) {
            int key = list[i];

            if (key != 0) {
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i+1));
            }
        }
    }

    public MidiEvent makeEvent(int command, int channel, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(command, channel, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }
}
