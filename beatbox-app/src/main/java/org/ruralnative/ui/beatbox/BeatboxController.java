package org.ruralnative.ui.beatbox;

import javax.sound.midi.*;
import javax.swing.*;
import java.util.ArrayList;

public class BeatboxController {
    private final BeatboxModel model;
    private Sequencer player;
    private Sequence sequence;
    private Track track;
    int[] trackList = null;

    protected BeatboxController() {
        this.model = new BeatboxModel();
        setupMidi();
    }

    protected ArrayList<JCheckBox> instantiateCheckBoxList() {
        model.setCheckBoxList(new ArrayList<>());
        return model.getCheckBoxList();
    }

    protected String getInstrumentName(int index) {
        return model.getInstrumentNames()[index];
    }

    protected int getInstrument(int index) {
        return model.getInstrumentList()[index];
    }

    private void setupMidi() {
        try {
            this.player = MidiSystem.getSequencer();
            player.open();
            this.sequence = new Sequence(Sequence.PPQ, 4);
            this.track = sequence.createTrack();
            player.setTempoInBPM(120);
        } catch (Exception e) {
            System.out.println("Midi Setup FAILED");
            System.out.println("SOURCE: setupMidi()");
            System.out.println("MIDI device cannot be opened OR division type (default of PPQ) is invalid");
        }
    }

    private void buildTrackAndStart() {
        sequence.deleteTrack(track);
        track = sequence.createTrack();
        readInstrumentBox();
        startPlayer();
    }

    private void readInstrumentBox() {
        for (int i = 0; i < 16; i++) {
            trackList = new int[16];
            int key = getInstrument(i);
            for (int j = 0; j < 16; j++) {
                JCheckBox jc = model.getCheckBoxList().get(j + (16*i));
                if (jc.isSelected()) {
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                }
            }
            makeTracks(trackList);
            track.add(makeEvent(176, 1, 127, 0, 16)); //For ControllerListener
        }
        track.add(makeEvent(192, 9, 1, 0, 15));
    }

    private void makeTracks(int[] list) {
        for (int i = 0; i < 16; i++) {
            int key = list[i];
            if (key != 0) {
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i+1));
            }
        }
    }

    private MidiEvent makeEvent(int command, int channel, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(command, channel, one, two);
            event = new MidiEvent(a, tick);
        } catch (InvalidMidiDataException e) {
            System.out.println("MidiEvent Instantiation FAILED");
            System.out.println("SOURCE: makeEvent()");
            System.out.println("Arguments for setMessage() or MidiEvent constructor does not specify a valid MidiMessage");
        }
        return event;
    }

    private void startPlayer() {
        try {
            player.setSequence(sequence);
            player.setLoopCount(player.LOOP_CONTINUOUSLY);
            player.start();
            player.setTempoInBPM(120);
        } catch (InvalidMidiDataException e) {
            System.out.println("Sequence Instantiation FAILED");
            System.out.println("SOURCE: buildTrackAndStart()");
            System.out.println("Sequence contains invalid/unsupported data");
        }
    }

    protected void handleStartButton() {
        buildTrackAndStart();
    }

    protected void handleStopButton() {
        player.stop();
    }

    protected void handleUpTempoButton() {
        float tempoFactor = player.getTempoFactor();
        player.setTempoFactor((float) (tempoFactor * 1.03));
    }

    protected void handleDownTempoButton() {
        float tempoFactor = player.getTempoFactor();
        player.setTempoFactor((float) (tempoFactor * 0.97));
    }
}
