package com.example.demo2.repository;

import com.example.demo2.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepos extends JpaRepository<Chapter,Integer> {
}
