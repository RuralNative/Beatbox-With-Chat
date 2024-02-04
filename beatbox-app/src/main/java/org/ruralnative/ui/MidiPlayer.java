package org.ruralnative.ui;

import javax.sound.midi.*;

public class MidiPlayer {
    public static void play() {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence sequence = new Sequence(Sequence.PPQ, 4);

            Track track = sequence.createTrack();

            ShortMessage messageOne = new ShortMessage();
            messageOne.setMessage(144, 1, 1, 100);
            MidiEvent noteOn = new MidiEvent(messageOne, 1);
            track.add(noteOn);

            ShortMessage messageTwo = new ShortMessage();
            messageTwo.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(messageTwo, 32);
            track.add(noteOff);

            player.setSequence(sequence);

            player.start();
        } catch (MidiUnavailableException m) {
            System.out.println("MidiUnavailableException THROWN!");
            System.out.println("Please check if MIDI device is used by another process.");
        } catch (InvalidMidiDataException i) {
            System.out.println("InvalidMidiDataException THROWN!");
            System.out.println("Please check if Sequence data is valid.");
        }
        System.out.println("Initialized SEQUENCER");
    }
}
