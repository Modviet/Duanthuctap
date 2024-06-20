package com.example.demo2.service;

import com.example.demo2.model.DoHomework;
import com.example.demo2.model.TestCase;
import com.example.demo2.repository.DoHomeworkRepos;
import com.example.demo2.repository.TestCaseRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoHomeworkService {

    @Autowired
    private DoHomeworkRepos doRepo;

    @Autowired
    private TestCaseRepos testRepo;

    public boolean runTestCase(int dohomeworkId,int testCaseId,String acOutput){
        DoHomework doHomework = doRepo.findById(dohomeworkId).orElseThrow();
        TestCase testCase = testRepo.findById(testCaseId).orElseThrow();

        boolean isCorrect = acOutput.equals(testCase.getOutputl());
        doHomework.setActualOutput(acOutput);
        doHomework.setIsFinished(true);
        doHomework.setHomeworkStatus(isCorrect ? DoHomework.HomeworkStatus.DUNG: DoHomework.HomeworkStatus.SAI);
        return isCorrect;
    }
}
