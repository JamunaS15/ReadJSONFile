package com.example.jsonFileRead.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jsonFileRead.model.Emails;
@Repository
public interface EmailsRepository extends JpaRepository<Emails, Integer>{

}
