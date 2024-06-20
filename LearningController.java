package com.example.demo2.controller;

import com.example.demo2.model.LearningProgress;
import com.example.demo2.service.LearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/learning-progress")
public class LearningController {

    @Autowired
    private LearningService learService;

    @GetMapping("/user/{usedId}")
    public ResponseEntity<List<LearningProgress>> getProgressById(@PathVariable int userId){
        List<LearningProgress> progressList = learService.getProgressByUserId(userId);
        return new ResponseEntity<>(progressList, HttpStatus.OK);
    }
}
