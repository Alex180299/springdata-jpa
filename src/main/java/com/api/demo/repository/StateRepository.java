package com.api.demo.repository;

import com.api.demo.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Repositorio para acceder a los objetos de la base de datos de los estados
 */
@Component
public interface StateRepository extends JpaRepository<State, Long> {
}
