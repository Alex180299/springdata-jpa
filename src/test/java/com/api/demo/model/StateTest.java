package com.api.demo.model;

import com.api.demo.repository.StateRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("Testing States")
class StateTest implements ModelTest {

    @Autowired
    StateRepository stateRepository;

    @BeforeEach
    void setUp(){
        stateRepository.save(new State(null, "State " + stateRepository.findAll().size(), "EU", "CODE"));
    }

    @DisplayName("Testing speed states")
    @RepeatedTest(value = 10, name = "{displayName}: {currentRepetition} of {totalRepetitions}")
    public void repeatedTest(TestInfo info, RepetitionInfo repetitionInfo){
        System.out.println(info.getDisplayName());
        System.out.println("Repetition: " + repetitionInfo.getCurrentRepetition());

        assertTimeout(Duration.ofMillis(10), ()->{
            stateRepository.findAll();
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"This", "is", "a", "test"})
    public void testValue(String value){
        System.out.println(value);
    }

    @DisplayName("Test from a method")
    @ParameterizedTest
    @MethodSource("getArguments")
    void testFromMethod(String clave, int valor){
        System.out.println(clave + valor);
    }

    static Stream<Arguments> getArguments(){
        return Stream.of(
                Arguments.of("Clave", 1),
                Arguments.of("Clave", 2),
                Arguments.of("Clave", 3)
        );
    }


}