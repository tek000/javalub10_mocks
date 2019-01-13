package com.demo.camera;

public class PhotoCamera implements WriteListener {

    boolean cameraPowerStatus;
    ImageSensor imageSensor;
    Card card;


    public PhotoCamera(ImageSensor imageSensor, Card card) {
        this.cameraPowerStatus = false;
        this.imageSensor = imageSensor;
        this.card = card;
    }

    public void turnOn() {
        cameraPowerStatus = true;
        imageSensor.turnOn();
    }

    public void turnOff() {
        writeCompleted();
        cameraPowerStatus = false;

    }

    public void pressButton() {
        if (this.cameraPowerStatus) {
            card.write(imageSensor.read());
        }
    }

    public boolean getCameraPowerStatus() {
        return cameraPowerStatus;
    }

    @Override
    public void writeCompleted() {

        imageSensor.turnOff();

    }
}

