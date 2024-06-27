package com.example.demo2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo2.model.MakeQuestion;
@Repository
public interface QuestionRepository extends JpaRepository<MakeQuestion, Integer> {

}
