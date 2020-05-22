package com.api.demo.controller;

import com.api.demo.model.School;
import com.api.demo.model.State;
import com.api.demo.repository.SchoolRepository;
import com.api.demo.service.SchoolService;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SchoolControllerTest {

    @Mock
    SchoolService schoolService;

    @InjectMocks
    SchoolController schoolController;

    @Autowired
    TestRestTemplate restTemplate;

    MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(schoolController).build();
    }

    @Test
    @DisplayName("Testing the SchoolController to one school")
    void getSchool() {
        try{
            mockMvc.perform(get("/school/1"))
                .andExpect(status().isOk());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Testing the SchoolController to get all the schools")
    void getAllSchools() {
        try{
            mockMvc.perform(get("/schools"))
                    .andExpect(status().isOk());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Testing the SchoolController to put one school on db")
    void putSchool() {
        School school = new School(null, "School 1", "website", new State(null, "State 1", "EU", "ST"));
        try{
            mockMvc.perform(post("/school")
                        .param("schoolParam", new Gson().toJson(school)))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Testing the SchoolController to get version of api")
    void getVersion() throws Exception {
        //assertEquals("Version: 1.0.0.0", schoolController.getVersion());
//        assertThat(schoolController.getVersion())
//                .isEqualTo("Version: 1.0.0.0")
//                .contains("Version");
        mockMvc.perform(get("http://localhost:8090/api/version"))
                .andExpect((ResultMatcher) jsonPath("$.Version", is("1.0.0.0")));
    }

    @Test
    @DisplayName("Testing the rest template")
    void restTemplateTest() {
        //String school = restTemplate.getForObject("http://localhost:8090/school/1", String.class);
        School school = restTemplate.getForObject("http://localhost:8090/school/1", School.class);

        assertThat(school).isNotNull();
        System.out.println(new Gson().toJson(school));
    }
}