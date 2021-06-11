package com.example.jsonFileRead.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jsonFileRead.model.Education;
@Repository
public interface EducationRepository extends JpaRepository<Education, Integer>{

}
