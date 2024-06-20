package com.example.demo2.service;

import com.example.demo2.model.Blog;
import com.example.demo2.model.LikeBlog;
import com.example.demo2.model.User;
import com.example.demo2.repository.BlogRepos;
import com.example.demo2.repository.LikeBlogRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeBlogService {

    @Autowired
    private LikeBlogRepos likeRepo;

    @Autowired
    private BlogRepos blogRepo;


    public List<LikeBlog> getData(){
        return likeRepo.findAll();
    }

    public Optional<LikeBlog> getLikeById(int id){
        return likeRepo.findById(id);
    }

    public LikeBlog createLike(LikeBlog likeBlog){
        return likeRepo.save(likeBlog);
    }

    public LikeBlog updateLike(int id,LikeBlog likeBlog){
        LikeBlog upLikeBlog = likeRepo.findById(id).orElseThrow(
                ()->new RuntimeException("Likeblog not found"));

        upLikeBlog.setUserId(likeBlog.getUserId());
        upLikeBlog.setBlogId(likeBlog.getBlogId());
        upLikeBlog.setUnlike(likeBlog.getUnlike());
        upLikeBlog.setCreateTime(likeBlog.getCreateTime());
        upLikeBlog.setUpdateTime(likeBlog.getUpdateTime());
        return likeRepo.save(upLikeBlog);
    }

    public void deleteLike(int id){
        LikeBlog likeBlog = likeRepo.findById(id).orElseThrow(
                ()->new RuntimeException("Likeblog not found"));

        likeRepo.delete(likeBlog);
    }






}
