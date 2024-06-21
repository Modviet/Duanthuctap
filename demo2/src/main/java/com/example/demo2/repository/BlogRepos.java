package com.example.demo2.repository;

import com.example.demo2.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepos extends JpaRepository<Blog,Integer> {

}
