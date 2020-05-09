package com.api.demo.repository;

import com.api.demo.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface SchoolRepository extends JpaRepository<School, Long> {
}
