package com.demo.camera;

public class PhotoCamera {

    private int size;

    private double quality;

    public PhotoCamera setQuality(double quality) {
        this.quality = quality;
        return this;
    }

    public PhotoCamera setSize(int size) {
        this.size = size;
        return this;
    }

    public static PhotoCamera main(String[] args) {
            return new PhotoCamera()
                .setQuality(2.0)
                .setSize(4);
    }

    public void turnOn() {
        // not implemented
    }

    public void turnOff() {
        // not implemented
    }

    public void pressButton() {
        // not implemented
    }
}

