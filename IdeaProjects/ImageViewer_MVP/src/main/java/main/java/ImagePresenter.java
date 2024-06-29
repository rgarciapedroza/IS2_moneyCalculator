package main.java;

import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class ImagePresenter {
    private ImageModel model;
    private ImageView view;

    public ImagePresenter(ImageModel model, ImageView view) {
        this.model = model;
        this.view = view;
        SwingUtilities.invokeLater(this::loadImage);
    }

    public void nextImage() {
        model.nextImage();
        loadImage();
    }

    public void lastImage() {
        model.lastImage();
        loadImage();
    }

    private void loadImage() {
        String filename = model.getPath();
        URL resource = getClass().getClassLoader().getResource(filename);
        if (resource != null) {
            ImageIcon icon = new ImageIcon(resource);
            Image image = icon.getImage();
            view.displayImage(image);

            int imgWidth = image.getWidth(null);
            int imgHeight = image.getHeight(null);
            float aspectRatio = (float) imgWidth / imgHeight;

            int frameWidth = 800;
            int frameHeight = 600;
            if (aspectRatio > 1) {
                frameHeight = (int) (frameWidth / aspectRatio);
            } else {
                frameWidth = (int) (frameHeight * aspectRatio);
            }

            view.updateSize(frameWidth, frameHeight);

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (screenSize.width - frameWidth) / 2;
            int y = (screenSize.height - frameHeight) / 2;
            view.updateLocation(x, y);
        } else {
            System.err.println("Resource not found: " + filename);
        }
    }
}
