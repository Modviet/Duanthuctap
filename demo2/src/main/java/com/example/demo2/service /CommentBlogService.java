package com.example.demo2.service;

import com.example.demo2.model.CommentBlog;
import com.example.demo2.repository.CommentBlogRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentBlogService {

    @Autowired
    private CommentBlogRepos commRepo;

   public List<CommentBlog> getAll(){
       return commRepo.findAll();
   }


   public CommentBlog createCommentBlog(CommentBlog commentBlog){
       return commRepo.save(commentBlog);
   }

   public CommentBlog updatCommentBlog(CommentBlog commentBlog){
       commentBlog.setEdited(true);
       return commRepo.save(commentBlog);
   }

   public void deleteCommentBlog(int comBlogId){
       commRepo.deleteById(comBlogId);
   }

   public List<CommentBlog> getCommentsByBlogId(int blogId){
       return commRepo.findByBlodId_Id(blogId);
   }

   public CommentBlog getCommentById(int id){
       return commRepo.findById(id).orElse(null);
   }
}
