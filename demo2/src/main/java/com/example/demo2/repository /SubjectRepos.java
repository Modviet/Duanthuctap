package com.example.demo2.repository;

import com.example.demo2.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepos extends JpaRepository<Subject,Integer> {
}
