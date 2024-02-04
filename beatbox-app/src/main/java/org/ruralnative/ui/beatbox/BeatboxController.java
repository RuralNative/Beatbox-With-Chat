package org.ruralnative.ui.beatbox;

public class BeatboxController {
    private BeatboxModel model;
    private BeatUI view;

    protected BeatboxController() {
        this.model = new BeatboxModel();
        this.view = new BeatUI();
    }

    protected String getInstrumentName(int index) {
        return model.getInstrumentNames()[index];
    }

    protected int getInstrument(int index) {
        return model.getInstrumentList()[index];
    }
}
