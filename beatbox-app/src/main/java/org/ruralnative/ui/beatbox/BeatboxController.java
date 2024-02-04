package org.ruralnative.ui.beatbox;

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
}
