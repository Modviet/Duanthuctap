package com.example.demo2.controller;

import com.example.demo2.model.Chapter;
import com.example.demo2.model.Course;
import com.example.demo2.model.Lesson;
import com.example.demo2.model.User;
import com.example.demo2.service.ChapterService;
import com.example.demo2.service.CourseService;
import com.example.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;
import java.util.List;

@RestController
@RequestMapping("/chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapService;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courService;

    @PostMapping("/{courseId}/add")
    public ResponseEntity<Chapter> addChapter(@RequestParam int intructorId,
                                              @PathVariable int courseId,
                                              @RequestBody Chapter chapter){
        User intructor = userService.findById(intructorId);
        Course course = courService.findById(courseId);
        Chapter newChapter = chapService.addChapter(intructor,course,chapter);
        return ResponseEntity.ok(newChapter);
    }

}
