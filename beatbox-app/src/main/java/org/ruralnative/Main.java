package org.ruralnative;

import org.ruralnative.ui.MusicTest1;

public class Main {
    public static void main(String[] args) {
        System.out.println("HI I am John Berlin");
        MusicTest1 test = new MusicTest1();
        test.play();
        SimpleGUI frame = new SimpleGUI();
        frame.go();
    }
}