package com.example.demo2.controller;

import com.example.demo2.model.CommentBlog;
import com.example.demo2.service.CommentBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment-blog")
public class CommentController {

    @Autowired
    private CommentBlogService commService;

    @GetMapping
    public ResponseEntity<List<CommentBlog>> getAll(){
        List<CommentBlog> danhsach = commService.getAll();
        return new ResponseEntity<>(danhsach, HttpStatus.OK);
    }

    @GetMapping("/blog/{blogId}")
    public ResponseEntity<List<CommentBlog>> getCommentsByBlogId(@PathVariable int blogId ){
       List<CommentBlog> comments = commService.getCommentsByBlogId(blogId);
       if(comments.isEmpty()){
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
          return new ResponseEntity<>(comments,HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<CommentBlog> createComment(@RequestBody CommentBlog commentBlog){
        CommentBlog newComment = commService.createCommentBlog(commentBlog);
        return new ResponseEntity<>(newComment,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentBlog> updateComment(@PathVariable int id ,
                                                     @RequestBody CommentBlog commentBlog){
            CommentBlog commentBlog1 = commService.getCommentById(id);
           if(commentBlog1 == null){
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
           }

           commentBlog1.setContebt(commentBlog.getContebt());
           commentBlog1.setEdited(true);
           CommentBlog updateComment = commService.updatCommentBlog(commentBlog1);
           return new ResponseEntity<>(updateComment,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable int id){
        CommentBlog commentBlog = commService.getCommentById(id);
        if(commentBlog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        commService.deleteCommentBlog(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
