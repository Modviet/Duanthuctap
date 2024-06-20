package com.example.demo2.service;

import com.example.demo2.model.Practice;
import com.example.demo2.repository.PracticeRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PracticeService {
    @Autowired
    private PracticeRepos pracRepo;

    public List<Practice> getData(){
        return pracRepo.findAll();
    }

    public Optional<Practice> getPracticeById(int id){
        return pracRepo.findById(id);
    }

    public Practice createPractice(Practice practice){
        return pracRepo.save(practice);
    }

    public Practice updatePractice(int id,Practice practice){
        Practice updatePrac = pracRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Practice not found"));

        updatePrac.setSubjectDetailId(practice.getSubjectDetailId());
        updatePrac.setLevel(practice.getLevel());
        updatePrac.setPracticeCode(practice.getPracticeCode());
        updatePrac.setTitle(practice.getTitle());
        updatePrac.setTopic(practice.getTopic());
        updatePrac.setExpectOutput(practice.getExpectOutput());
        updatePrac.setLanguageProgramingId(practice.getLanguageProgramingId());
        updatePrac.setIsRequired(practice.getIsRequired());
        updatePrac.setCreateTime(practice.getCreateTime());
        updatePrac.setUpdateTime(practice.getUpdateTime());
        updatePrac.setIsDeleted(practice.getIsDeleted());
        updatePrac.setMediumScore(practice.getMediumScore());

        return pracRepo.save(updatePrac);
    }

    public void deletePractice(int id){
        Practice prac = pracRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Practice not found"));

        pracRepo.delete(prac);
    }
}
