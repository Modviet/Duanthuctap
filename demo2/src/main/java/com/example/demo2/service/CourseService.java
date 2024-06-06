package com.example.demo2.service;

import com.example.demo2.repository.CourseRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepos courRepo;

    
}
