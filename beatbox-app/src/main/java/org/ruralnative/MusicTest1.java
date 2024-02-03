package org.ruralnative;

import javax.sound.midi;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;

public class MusicTest1 {

    public void play() {
        Sequencer sequencer = MidiSystem.getSequencer();
        System.out.println("Initialized SEQUENCER");
    }
}
