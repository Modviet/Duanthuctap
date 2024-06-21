package com.example.demo2.controller;

import com.example.demo2.model.Practice;
import com.example.demo2.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/practice")
public class PracticeController {

    @Autowired
    private PracticeService pracService;

    @GetMapping
    public ResponseEntity<List<Practice>> getAll(){
        List<Practice> danhsach = pracService.getData();
        return new ResponseEntity<>(danhsach, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Practice> getPracticeById(@PathVariable int id){
        Optional<Practice> practice = pracService.getPracticeById(id);
        if (practice.isPresent()){
            return ResponseEntity.ok(practice.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Practice> createPractice(@RequestBody Practice practice){
        Practice newPractice = pracService.createPractice(practice);
        return new ResponseEntity<>(newPractice,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Practice> updatePractice(@PathVariable int id,
                                                   @RequestBody Practice practice){
        Optional<Practice> newPractice = pracService.getPracticeById(id);
        if(!newPractice.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Practice updatePractice = newPractice.get();
        updatePractice.setSubjectDetailId(practice.getSubjectDetailId());
        updatePractice.setLevel(practice.getLevel());
        updatePractice.setPracticeCode(practice.getPracticeCode());
        updatePractice.setTitle(practice.getTitle());
        updatePractice.setTopic(practice.getTopic());
        updatePractice.setExpectOutput(practice.getExpectOutput());
        updatePractice.setLanguageProgramingId(practice.getLanguageProgramingId());
        updatePractice.setIsDeleted(practice.getIsDeleted());
        updatePractice.setIsRequired(practice.getIsRequired());
        updatePractice.setCreateTime(practice.getCreateTime());
        updatePractice.setUpdateTime(practice.getUpdateTime());
        updatePractice.setMediumScore(practice.getMediumScore());

        Practice upPractice = pracService.updatePractice(id,updatePractice);
        return ResponseEntity.ok(upPractice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePractice(@PathVariable int id){
        pracService.deletePractice(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
