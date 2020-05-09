package com.api.demo.repository;

import com.api.demo.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface StateRepository extends JpaRepository<State, Long> {
}
