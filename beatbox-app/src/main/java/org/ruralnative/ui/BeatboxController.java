package org.ruralnative.ui;

import javax.sound.midi.*;

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
