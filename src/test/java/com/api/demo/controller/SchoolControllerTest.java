package com.api.demo.controller;

import com.api.demo.repository.SchoolRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@SpringBootTest
class SchoolControllerTest {

    @Autowired
    SchoolController schoolController;

    @Test
    @DisplayName("Testing the SchoolController to get all the schools")
    void getAllSchools() {
        assumeFalse(schoolController.equals(null));
        assertTimeout(Duration.ofMillis(200), () -> {
            schoolController.getAllSchools();
        });
    }

    @Test
    @DisplayName("Testing the SchoolController to get version of api")
    void getVersion() {
        //assertEquals("Version: 1.0.0.0", schoolController.getVersion());
        assertThat(schoolController.getVersion())
                .isEqualTo("Version: 1.0.0.0")
                .contains("Version")
                .isLowerCase();
    }
}