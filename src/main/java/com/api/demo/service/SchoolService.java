package com.api.demo.service;

import com.api.demo.model.School;

import java.util.List;

/**
 * Interfaz del servicio de la capa de acceso a datos de las escuelas
 */
public interface SchoolService {
    public List<School> findAll();
    public School findById(Long id);
    public School save(School school);
}
