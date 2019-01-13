package com.demo.camera;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class PhotoCameraTest {

    @Test
    public void changeMe() {
        Assertions
                .assertThat(Arrays.asList(2, 3))
                .isNotNull()
                .contains(3)
                .doesNotContain(5)

        ;

        Assertions
                .assertThat(this)
                .isNotNull();

    }


    @Test
    public void IsCameraTurnedOffAfterCreation() {
        ImageSensor sensor = mock(ImageSensor.class);
        Card card = mock(Card.class);

        PhotoCamera camera = new PhotoCamera(sensor, card);

        boolean isTurnedOn = camera.getCameraPowerStatus();

        Assert.assertFalse(isTurnedOn);

    }

    @Test
    public void TurningOnCameraIsTurningOnSensor() {


        ImageSensor sensor = mock(ImageSensor.class);
        Card card = mock(Card.class);

        PhotoCamera camera = new PhotoCamera(sensor, card);
        camera.turnOn();
        Mockito.verify(sensor).turnOn();

    }


    @Test
    public void TurningOffCameraIsTurningSensorOff() {


        ImageSensor sensor = mock(ImageSensor.class);
        Card card = mock(Card.class);

        PhotoCamera camera = new PhotoCamera(sensor, card);
        camera.turnOn();
        camera.turnOff();
        Mockito.verify(sensor).turnOff();

    }

    @Test
    public void pressButtonOnCameraDuringPowerOffDoesNoInteractionWithSensor() {

        ImageSensor sensor = mock(ImageSensor.class);
        Card card = mock(Card.class);

        PhotoCamera camera = new PhotoCamera(sensor, card);
        camera.pressButton();
        Mockito.verifyZeroInteractions(sensor);
    }

    @Test
    public void pressButtonOnWhileCameraIsOnCopyDataFromSensorToMemCard() {

        ImageSensor sensor = mock(ImageSensor.class);
        Card card = mock(Card.class);

        PhotoCamera camera = new PhotoCamera(sensor, card);
        camera.turnOn();

        byte[] data = "data".getBytes();

        Mockito.when(sensor.read()).thenReturn(data);
        camera.pressButton();
        Mockito.verify(card).write(data);

    }

    @Test
    public void PowerOffCameraDoesNotPowerOffSensorWhileWriteToCardIsNotCompleted(){
        ImageSensor sensor = mock(ImageSensor.class);
        Card card = mock(Card.class);
        PhotoCamera camera = new PhotoCamera(sensor, card);
        camera.turnOn();
        byte[] data = "data".getBytes();
        Mockito.when(sensor.read()).thenReturn(data);
        camera.pressButton();
        camera.turnOff();
        boolean isWriteCompleted = camera.isWriteCompleted;
        Assert.assertFalse(isWriteCompleted);
    }
    @Test
    public void PowerOffCameraDoesNotPowerOffSensorWhileWriteToCardIsCompleted(){
        ImageSensor sensor = mock(ImageSensor.class);
        Card card = mock(Card.class);
        PhotoCamera camera = new PhotoCamera(sensor, card);
        camera.turnOn();
        byte[] data = "data".getBytes();
        Mockito.when(sensor.read()).thenReturn(data);
        camera.pressButton();
        camera.writeCompleted();
        camera.turnOff();
        boolean isWriteCompleted = camera.isWriteCompleted;
        Assert.assertTrue(isWriteCompleted);
    }

}