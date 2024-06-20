package com.example.demo2.repository;

import com.example.demo2.model.RunTestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunTestCaseRepos extends JpaRepository<RunTestCase,Integer> {
}
