package main.java;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel implements ImageView {
    private Image image;

    public ImagePanel() {
        this.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }

    @Override
    public void displayImage(Image image) {
        this.image = image;
        repaint();
    }

    @Override
    public void updateSize(int width, int height) {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (topFrame != null) {
            topFrame.setSize(width, height);
        }
    }

    @Override
    public void updateLocation(int x, int y) {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (topFrame != null) {
            topFrame.setLocation(x, y);
        }
    }
}
