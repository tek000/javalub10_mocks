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
        ImageSensor sensor = mock(ImageSensor.class);
        PhotoCamera camera = new PhotoCamera(sensor);

        boolean isTurnedOn = camera.getCameraPowerStatus();

        Assert.assertFalse(isTurnedOn);

    }
    @Test
    public void TurningOnCameraIsTurningOnSensor() {


        ImageSensor sensor = mock(ImageSensor.class);
        PhotoCamera camera = new PhotoCamera(sensor);
        camera.turnOn();
        Mockito.verify(sensor).turnOn();

    }
}