package com.example.demo2.repository;

import com.example.demo2.model.LearningProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearningProgressRepos extends JpaRepository<LearningProgress,Integer> {
    List<LearningProgress> findByUserId(int usedId);
}
