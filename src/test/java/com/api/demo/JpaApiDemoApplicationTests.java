package com.api.demo;

import com.api.demo.controller.SchoolController;
import com.api.demo.model.School;
import com.api.demo.model.State;
import com.api.demo.repository.SchoolRepository;
import com.api.demo.repository.StateRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.EnabledIf;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {JpaApiDemoApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class JpaApiDemoApplicationTests {

	@Autowired
	SchoolRepository schoolRepository;

	@Autowired
	StateRepository stateRepository;

	@BeforeAll
	static void beforeAll(){
        System.out.println("Before all");
	}

	@BeforeEach
	void setUp(){
        System.out.println("Before each");
		schoolRepository.save(new School(null,"Name", "Web", new State(null, "Alabama", "EU", "AL")));
	}

	@Test
	@DisplayName("Testing duration of the findAll method from the SchoolRepository")
	@EnabledOnOs(OS.MAC)
	@EnabledOnJre(JRE.JAVA_8)
	@EnabledIfEnvironmentVariable(named = "USER", matches = "alejandroortizpablo")
	//@EnabledIf("Math.random() > 0.1")
	public void testJPA() {
		assertTimeout(Duration.ofMillis(200), () -> {
			schoolRepository.findAll().forEach(s -> System.out.println(s.getName()));
		});
	}

	@Test
	@DisplayName("Testing duration of the findAll method from the StateRepository")
	@EnabledIfEnvironmentVariable(named = "USER", matches = "joel")
	@EnabledOnOs(OS.WINDOWS)
	public void testJPA2() {
		assertAll("Block of asserts",
				() -> assertTimeout(Duration.ofMillis(200), () -> {
					stateRepository.findAll().forEach(s -> System.out.println(s.getSchools().get(0).getWebsite()));
				}),
				() -> assertNotNull(stateRepository.findAll())
		);
	}

	@AfterEach
	void afterEach(){
		System.out.println("After each");
	}

	@AfterAll
	static void afterAll(){
		System.out.println("After all");
	}


}
