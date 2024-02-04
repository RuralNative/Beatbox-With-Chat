package org.ruralnative.ui.beatbox;

import javax.swing.*;
import java.awt.*;

class BeatboxView extends JFrame {
    private Container container;
    private DrawPanel panel;
    private JButton button;

    public BeatboxView() {
        super("Beat Box App");

        panel = new DrawPanel();
        button = new JButton("Click Me");

        container = getContentPane();
        container.add(BorderLayout.CENTER, panel);
        container.add(BorderLayout.SOUTH, button);

        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    protected JButton getButton() {
        return this.button;
    }

    class DrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            Graphics2D graphics = (Graphics2D) g;
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            graphics.setColor(new Color(red, green, blue));
            int height = (int) ((Math.random() * 120) + 10);
            int width = (int) ((Math.random() * 120) + 10);
            int x = (int) ((Math.random() * 200) + 10);
            int y = (int) ((Math.random() * 200) + 10);
            graphics.fillRect(x, y, width,height);
        }
    }
}

