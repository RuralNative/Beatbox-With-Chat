package org.ruralnative.ui.beatbox;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;
import javax.swing.*;
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
        Sequencer player;
        Sequence sequence;
        Track track;
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
