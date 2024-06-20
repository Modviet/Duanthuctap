package com.example.demo2.repository;

import com.example.demo2.model.ProgramingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramingLanguageRepos extends JpaRepository<ProgramingLanguage,Integer> {
}
