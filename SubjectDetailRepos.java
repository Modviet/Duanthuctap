package com.example.demo2.repository;

import com.example.demo2.model.SubjectDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectDetailRepos extends JpaRepository<SubjectDetail,Integer> {
}
