package com.api.demo.model;

import com.api.demo.controller.SchoolController;
import com.api.demo.repository.SchoolRepository;
import com.api.demo.repository.StateRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@SpringBootTest
@DisplayName("Test school")
class SchoolTest implements ModelTest {

    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    StateRepository stateRepository;

    @Autowired
    SchoolController schoolController;

    @Nested
    @DisplayName("Insert States")
    class TestInsertStates {

        @BeforeEach
        void setUp(){
            State state = new State(null, "State " + stateRepository.findAll().size(), "EU", "CODE");

            stateRepository.save(state);
        }

        @Test
        @DisplayName("Counting states")
        void count(){
            int states = stateRepository.findAll().size();
            assertThat(states).isNotZero().isEqualTo(1);
        }

        @Nested
        @DisplayName("Insert Schools")
        class TestInsertSchools {

            List<State> stateList;

            @BeforeEach
            void insert(){
                stateList = stateRepository.findAll();
                assumeTrue(stateList.size() > 0);

                stateList.forEach(state -> {
                    schoolRepository.save(new School(null, "School " + state.getId(), "www.school.com", state));
                });
            }

            @Test
            @DisplayName("Counting schools")
            public void count(){
                int schools = schoolRepository.findAll().size();

                schoolRepository.findAll().forEach(s -> {
                    System.out.println(s.getName());
                });

                assertThat(schools).isNotZero().isEqualTo(2);
            }

            @Test
            @DisplayName("Testing mapped by")
            public void testMapped(){
                List<School> schoolList = schoolController.getAllSchools();

                assertThat(schoolList.size()).isNotZero().isEqualTo(5);
                assertAll("School mapped",
                        () -> assertThat(schoolList.get(0).getState()).isNotNull(),
                        () -> assertThat(schoolList.get(0).getState().getSchools()).isNotNull(),
                        () -> assertThat(schoolList.get(0).getState().getSchools().size()).isEqualTo(2)
                );
            }
        }

    }

}