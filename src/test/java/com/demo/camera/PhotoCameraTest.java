package com.demo.camera;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

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
    public void  IsCameraTurnedOffAfterCreation(){

        PhotoCamera camera = new PhotoCamera();
        boolean isTurnedOn = camera.getPowerStatus();

        Assert.assertFalse(isTurnedOn);

    }
    @Test
    public void TurningOnCameraIsTurningOnSensor() {
        PhotoCamera camera = new PhotoCamera();
        camera.turnOn();
        ImageSensor sensor = mock(ImageSensor.class);
        Mockito.verify(sensor).turnOn();

    }
}