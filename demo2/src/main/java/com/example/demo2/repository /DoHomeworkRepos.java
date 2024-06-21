package com.example.demo2.repository;

import com.example.demo2.model.DoHomework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoHomeworkRepos extends JpaRepository<DoHomework,Integer> {
}
