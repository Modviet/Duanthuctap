package com.example.demo2.service;

import com.example.demo2.model.LearningProgress;
import com.example.demo2.repository.LearningProgressRepos;
import com.example.demo2.repository.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearningService {

    @Autowired
    private LearningProgressRepos learRepo;

    @Autowired
    private UserRepos userRepo;

    public List<LearningProgress> getProgressByUserId(int userId){
        userRepo.findById(userId).
                orElseThrow(()->new RuntimeException("User not found"));

        return learRepo.findByUserId(userId);
    }

}
