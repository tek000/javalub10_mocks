package com.demo.camera;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.Test;

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

}