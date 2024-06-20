package com.example.demo2.service;

import com.example.demo2.model.Blog;
import com.example.demo2.repository.BlogRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogRepos blogRepo;

    public List<Blog> getData(){
        return blogRepo.findAll();
    }

    public Blog createBlog(Blog blog){
        blog.setCreateTime(LocalDate.now());
        blog.setUpdateTime(LocalDate.now());
        return blogRepo.save(blog);
    }

    public Blog updateBlog(Blog blog){
        blog.setUpdateTime(LocalDate.now());
        return blogRepo.save(blog);
    }

    public void deleteBlog(int blogId){
        blogRepo.deleteById(blogId);
    }

    public Blog getBlogById(int blogId){
        return blogRepo.findById(blogId).orElse(null);
    }
}
