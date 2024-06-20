package com.example.demo2.controller;


import com.example.demo2.model.Chapter;
import com.example.demo2.model.Lesson;
import com.example.demo2.model.User;
import com.example.demo2.service.ChapterService;
import com.example.demo2.service.LessonService;
import com.example.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    private LessonService lessService;

    @Autowired
    private UserService userService;

    @Autowired
    private ChapterService chapService;

    @PostMapping("/{chapterId}/add")
    public ResponseEntity<Lesson> addLesson(@RequestParam int intructorId,
                                            @PathVariable int chapterId,
                                            @RequestBody Lesson lesson){
        User intructor = userService.findById(intructorId);
        Chapter chapter = chapService.findById(chapterId);
        Lesson newLesson = lessService.addLesson(intructor,chapter,lesson);
        return ResponseEntity.ok(newLesson);
    }

}
