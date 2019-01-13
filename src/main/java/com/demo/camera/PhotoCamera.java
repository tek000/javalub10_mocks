package com.demo.camera;

public class PhotoCamera implements ImageSensor{


    boolean cameraPowerStatus;
    ImageSensor imageSensor;

    public PhotoCamera(ImageSensor imageSensor) {
        this.cameraPowerStatus = false;
        this.imageSensor = imageSensor;
    }

    public void turnOn() {
       cameraPowerStatus = true;
       imageSensor.turnOn();
    }

    public void turnOff() {
        cameraPowerStatus = false;
        imageSensor.turnOff();
    }

    @Override
    public byte[] read() {
        return new byte[0];
    }

    public boolean pressButton() {
        if (!this.cameraPowerStatus ){
            return false;
        }else return true;

    }

    public boolean getCameraPowerStatus() {
        return cameraPowerStatus;
    }



}

