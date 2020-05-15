package com.api.demo.service;

import com.api.demo.model.School;
import com.api.demo.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementación del servicio de la capa de acceso a datos
 */
@Service
public class SchoolServiceImpl implements SchoolService{

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    @Transactional(readOnly = true)
    public List<School> findAll() {
        return schoolRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public School findById(Long id) {
        return schoolRepository.findById(id).orElse(null);
    }

    @Override
    public School save(School school) {
        return schoolRepository.save(school);
    }
}
