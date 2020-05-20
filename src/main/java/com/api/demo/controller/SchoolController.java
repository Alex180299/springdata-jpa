package com.api.demo.controller;

import com.api.demo.model.School;
import com.api.demo.repository.SchoolRepository;
import com.api.demo.service.SchoolService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador rest para acceder a la información de las escuelas
 */
@RestController
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Método para obtener todas las escuelas que existen en la base de datos
     * @return Un objeto List<School> con todas las escuelas
     */
    @GetMapping("/schools")
    public List<School> getAllSchools(){
//        return schoolService.findAll()
//                .stream()
//                .map(s -> {
//                    School school = new School();
//                    school.setName(s.getName());
//                    school.setId(s.getId());
//                    school.setWebsite(s.getWebsite());
//                    return school;
//                })
//                .collect(Collectors.toList());
        return schoolService.findAll();
    }

    /**
     * Método para obtener solamente una escuela con un id específico
     * @param id El id de la escuela que se desee
     * @return Un objeto List<School>
     */
    @GetMapping("/school/{id}")
    public School getSchoolById(@PathVariable Long id){
        return schoolService.findById(id);
    }

    /**
     * Método para introducir una escuela
     * @param schoolParam Entidad con la información de la escuela para guardarla en la base
     * @return Un string con el mensaje de inserción exitosa
     */
    @PostMapping("/school")
    public String insertSchool(@RequestParam String schoolParam) {
        School school = null;

        try{
            school = objectMapper.readValue(schoolParam, School.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        schoolService.save(school);
        return "{ message: School " + school.getName() + " success inserted }";
    }

    /**
     * Método para introducir una escuela
     * @param schoolParam Entidad con la información de la escuela para guardarla en la base
     * @return Un string con el mensaje de inserción exitosa
     */
    @PostMapping("/api/version")
    public String getVersion() {
        return "Version: 1.0.0.0";
    }
}
