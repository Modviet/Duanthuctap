package com.example.demo2.repository;

import com.example.demo2.model.LikeBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface LikeBlogRepos extends JpaRepository<LikeBlog,Integer> {

}
