package com.example.demo2.repository;

import com.example.demo2.model.CommentBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentBlogRepos extends JpaRepository<CommentBlog,Integer> {

    List<CommentBlog> findByBlodId_Id(int blogId);
}
