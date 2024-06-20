package com.example.demo2.repository;

import com.example.demo2.model.Practice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticeRepos extends JpaRepository<Practice,Integer> {
}
