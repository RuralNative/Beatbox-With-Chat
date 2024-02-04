package org.ruralnative.ui;

import javax.sound.midi.*;

public class MidiPlayer {
    public static void play() {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            for (int i = 5; i < 61; i += 4) {
                track.add(makeEvent(144, 1, i, 100, i));
                track.add(makeEvent(128, 1, i, 100, i + 2));
            }

            player.setSequence(sequence);
            player.setTempoInBPM(220);
            player.start();
        } catch (MidiUnavailableException m) {
            System.out.println("MidiUnavailableException THROWN!");
            System.out.println("Please check if MIDI device is used by another process.");
        } catch (InvalidMidiDataException e) {
            System.out.println("InvalidMidiDataException THROWN!");
            System.out.println("Please check if Sequence data is valid.");
        }
        System.out.println("Initialized SEQUENCER");
    }

    public static MidiEvent makeEvent(int command, int channel, int dataOne, int dataTwo, int tick) {
        MidiEvent note = null;
        try {
            ShortMessage message = new ShortMessage();
            message.setMessage(command, channel, dataOne, dataTwo);
            note = new MidiEvent(message, tick);
        } catch (InvalidMidiDataException e) {
            System.out.println("InvalidMidiDataException THROWN!");
            System.out.println("Please check if MidiEvent data is valid.");
        }
        return note;
    }
}
