package org.ruralnative.ui.beatbox;

import org.ruralnative.ui.MidiPlayer;

public class BeatboxController {

    private BeatBoxModel model;
    private BeatboxView view;

    public BeatboxController() {
        this.model = new BeatBoxModel();
        this.view = new BeatboxView();
        view.getButton().addActionListener(e -> handleButton());
    }

    private void handleButton() {
        MidiPlayer.play();
    }
}
