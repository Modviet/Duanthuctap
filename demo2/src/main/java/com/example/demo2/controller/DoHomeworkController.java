package com.example.demo2.controller;

import com.example.demo2.service.DoHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dohomework")
public class DoHomeworkController {

    @Autowired
    private DoHomeworkService doService;

    @PostMapping("/run-test-case")
    public boolean runTestCase(@RequestParam int doHomeworkId,
                               @RequestParam int testCaseId,
                               @RequestParam String acOutput){
        return doService.runTestCase(doHomeworkId, testCaseId, acOutput);
    }

}
