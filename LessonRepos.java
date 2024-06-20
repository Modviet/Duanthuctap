package com.example.demo2.repository;

import com.example.demo2.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepos extends JpaRepository<Lesson,Integer> {
}
