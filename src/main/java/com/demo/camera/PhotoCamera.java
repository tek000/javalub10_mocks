package com.demo.camera;

public class PhotoCamera implements ImageSensor{


    boolean powerStatus;

//    private int size;
//
//    private double quality;
//
//    public PhotoCamera setQuality(double quality) {
//        this.quality = quality;
//        return this;
//    }
//
//    public PhotoCamera setSize(int size) {
//        this.size = size;
//        return this;
//    }

//    public static PhotoCamera main(String[] args) {
//            return new PhotoCamera()
//                .setQuality(2.0)
//                .setSize(4);
//    }

//    public static PhotoCamera main(String[] args) {
//        return new PhotoCamera();
//
//    }


    public PhotoCamera() {
        this.powerStatus = false;
    }

    public void turnOn() {
        // not implemented
    }

    public void turnOff() {
        // not implemented
    }

    @Override
    public byte[] read() {
        return new byte[0];
    }

    public void pressButton() {
        // not implemented
    }

    public boolean getPowerStatus() {
        return powerStatus;
    }



}

