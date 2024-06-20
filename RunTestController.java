package com.example.demo2.controller;

import com.example.demo2.model.RunTestCase;
import com.example.demo2.service.RunTestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/run-test")
public class RunTestController {

    @Autowired
    private RunTestCaseService runService;

    @GetMapping
    public ResponseEntity<List<RunTestCase>> getData(){
        List<RunTestCase> danhsach = runService.getAll();
        return new ResponseEntity<>(danhsach, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<RunTestCase> createRunTest(@RequestBody RunTestCase runTestCase){
        RunTestCase newRun = runService.createRunTest(runTestCase);
        return new ResponseEntity<>(newRun,HttpStatus.CREATED);
    }

}
