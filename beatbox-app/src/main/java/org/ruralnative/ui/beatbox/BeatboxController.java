package org.ruralnative.ui.beatbox;

public class BeatboxController {
    private BeatboxModel model;
    private BeatboxUI view;

    protected BeatboxController() {
        this.model = new BeatboxModel();
        this.view = new BeatboxUI()
    }
}
