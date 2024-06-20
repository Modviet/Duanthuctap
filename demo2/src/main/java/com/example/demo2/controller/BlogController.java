package com.example.demo2.controller;

import com.example.demo2.model.Blog;
import com.example.demo2.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping
    public ResponseEntity<List<Blog>> getAll(){
        List<Blog> danhsach = blogService.getData();
        return new ResponseEntity<>(danhsach, HttpStatus.OK);
    }

    @GetMapping("id")
    public ResponseEntity<Blog> getBlogById(@PathVariable int id){
       Blog blog = blogService.getBlogById(id);
       if(blog != null){
           return new ResponseEntity<>(blog,HttpStatus.OK);
       } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @PostMapping
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog){
        Blog newBlog = blogService.createBlog(blog);
        return new ResponseEntity<>(newBlog,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable int blogId,
                                           @RequestBody Blog blog){
         Blog blog1 = blogService.getBlogById(blogId);
         if(blog1 == null){
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }

         blog.setId(blogId);
         Blog updateBlog = blogService.updateBlog(blog);
         return new ResponseEntity<>(updateBlog,HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable int blogId){
        Blog deleteBlog = blogService.getBlogById(blogId);
        if (deleteBlog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        blogService.deleteBlog(blogId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}

