package com.example.demo2.controller;

import com.example.demo2.model.LikeBlog;
import com.example.demo2.repository.LikeBlogRepos;
import com.example.demo2.service.LikeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/like-blog")
public class LikeController {

    @Autowired
    private LikeBlogService likeService;

    @GetMapping
    public ResponseEntity<List<LikeBlog>> getAll(){
        List<LikeBlog> danhsach = likeService.getData();
        return new ResponseEntity<>(danhsach, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LikeBlog> getLikeByID(@PathVariable int id){
        Optional<LikeBlog> likeBlogs = likeService.getLikeById(id);
        if(likeBlogs.isPresent()){
            return ResponseEntity.ok(likeBlogs.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<LikeBlog> createLike(@RequestBody LikeBlog likeBlog){
        LikeBlog newLike = likeService.createLike(likeBlog);
        return new ResponseEntity<>(newLike,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LikeBlog> updateLike(@PathVariable int id,
                                               @RequestBody LikeBlog likeBlog){
        LikeBlog updateLike = likeService.updateLike(id,likeBlog);
        return new ResponseEntity<>(updateLike,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLike(@PathVariable int id){
        likeService.deleteLike(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
