package com.example.demo2.repository;

import com.example.demo2.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCaseRepos extends JpaRepository<TestCase,Integer> {
}
