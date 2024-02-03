package org.ruralnative;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class MusicTest1 {

    public void play() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
        } catch (MidiUnavailableException m) {
            System.out.println("MidiUnavailableException THROWN!");
            System.out.println("Please check if MIDI device is used by another process.");
        }
        System.out.println("Initialized SEQUENCER");
    }
}
