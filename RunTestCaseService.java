package com.example.demo2.service;

import com.example.demo2.model.RunTestCase;
import com.example.demo2.repository.RunTestCaseRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunTestCaseService {

    @Autowired
    private RunTestCaseRepos runRepo;

    public List<RunTestCase> getAll(){
        return runRepo.findAll();
    }

    public RunTestCase createRunTest(RunTestCase runTestCase){
        return runRepo.save(runTestCase);
    }
}
