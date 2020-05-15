package com.api.demo.repository;

import com.api.demo.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Repositorio para acceder a los objetos de la base de datos de escuelas
 */
@Component
public interface SchoolRepository extends JpaRepository<School, Long> {
}
