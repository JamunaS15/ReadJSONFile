package com.example.jsonFileRead.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jsonFileRead.model.Experience;
@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer>{

}
