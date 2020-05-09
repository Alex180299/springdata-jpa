package com.api.demo.controller;

import com.api.demo.model.School;
import com.api.demo.repository.SchoolRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/schools")
    public List<School> getAllSchools(){
        return schoolRepository.findAll();
    }

    @PostMapping("/school")
    public String insertSchool(@RequestParam String schoolParam) {
        School school = null;

        try{
            school = objectMapper.readValue(schoolParam, School.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        schoolRepository.save(school);
        return "{ message: School " + school.getName() + " success inserted }";
    }

}
