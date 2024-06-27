package com.example.demo2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo2.model.Answers;

@Repository
public interface AnswerRepository extends JpaRepository<Answers, Integer>{

}
