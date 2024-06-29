package main.java;

public class ImageModel {
    private String[] imagePaths;
    private int imageIndex;

    public ImageModel() {
        imagePaths = new String[]{
                "imagen1.jpg",
                "imagen2.jpg",
                "imagen3.jpeg",
                "imagen4.jpg",
                "imagen5.jpeg",
                "imagen6.jpg"
        };
        imageIndex = 0;
    }

    public String getPath() {
        return imagePaths[imageIndex];
    }

    public void nextImage() {
        imageIndex = (imageIndex + 1) % imagePaths.length;
    }

    public void lastImage() {
        imageIndex = (imageIndex - 1 + imagePaths.length) % imagePaths.length;
    }
}
