package com.api.demo;

import com.api.demo.model.School;
import com.api.demo.model.State;
import com.api.demo.repository.SchoolRepository;
import com.api.demo.repository.StateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaApiDemoApplicationTests {

	@Autowired
	SchoolRepository schoolRepository;

	@Autowired
	StateRepository stateRepository;

	@Test
	void testJPA() {
		schoolRepository.save(new School(null,"Name", "Web", new State(null, "Alabama", "EU", "AL")));
		stateRepository.findAll().forEach(s -> System.out.println(s.getSchools().get(0).getWebsite()));
	}

}
