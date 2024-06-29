package main.java;

import java.awt.Image;

public interface ImageView {
    void displayImage(Image image);
    void updateSize(int width, int height);
    void updateLocation(int x, int y);
}
