package com.example.demo2.repository;

import com.example.demo2.model.RegisterStudy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterStudyRepos extends JpaRepository<RegisterStudy,Integer> {
}
