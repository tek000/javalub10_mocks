package com.demo.camera;

public class PhotoCamera implements WriteListener {

    boolean cameraPowerStatus;
    boolean isWriteCompleted = false;
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
        if (isWriteCompleted) {

            imageSensor.turnOff();
            cameraPowerStatus = false;

        } else {

            cameraPowerStatus = false;

        }

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
        isWriteCompleted = true;
        if (!cameraPowerStatus){
         turnOff();
        }
    }
}

