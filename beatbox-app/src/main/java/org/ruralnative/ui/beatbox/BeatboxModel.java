package org.ruralnative.ui.beatbox;

import javax.swing.*;
import java.util.ArrayList;

public class BeatboxModel {
    private ArrayList<JCheckBox> checkBoxList;

    private final String[] instrumentNames = {
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

    private final int[] instruments = {
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

    protected ArrayList<JCheckBox> getCheckBoxList() {
        return this.checkBoxList;
    }

    protected String setCheckBoxList(ArrayList<JCheckBox> list) {
        this.checkBoxList = list;
        return "CheckBoxList INSTANTIATED";
    }

    protected String[] getInstrumentNames() {
        return this.instrumentNames;
    }

    protected int[] getInstrumentList() {
        return this.instruments;
    }
}
