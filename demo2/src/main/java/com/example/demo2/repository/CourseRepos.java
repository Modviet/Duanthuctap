package com.example.demo2.repository;

import com.example.demo2.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepos extends JpaRepository<Course,Integer> {

}
