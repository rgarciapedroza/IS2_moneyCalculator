package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    private ImagePanel imagePanel;
    private ImagePresenter presenter;
    private Point initialClick;

    public MainFrame() throws HeadlessException {
        ImageModel model = new ImageModel();
        imagePanel = new ImagePanel();

        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(imagePanel, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);

        presenter = new ImagePresenter(model, imagePanel);

        imagePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int deltaX = e.getX() - initialClick.x;
                if (deltaX > 50) {
                    presenter.nextImage();
                } else if (deltaX < -50) {
                    presenter.lastImage();
                }
            }
        });

        pack();
    }
}
