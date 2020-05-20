package com.api.demo.model;

import org.junit.jupiter.api.*;

@Tag("Model")
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface ModelTest {

//    @BeforeAll
//    default void beforeAll(){
//        System.out.println("Starting the tests");
//    }

    @BeforeEach
    default void beforeEachMethod(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.println("Starting new test repetition: " + repetitionInfo + " on method: " + testInfo.getDisplayName());
    }

}
