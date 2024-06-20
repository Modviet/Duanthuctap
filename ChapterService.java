package com.example.demo2.service;

import com.example.demo2.model.Chapter;
import com.example.demo2.model.Course;
import com.example.demo2.model.Lesson;
import com.example.demo2.model.User;
import com.example.demo2.repository.ChapterRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterService {

    @Autowired
    private ChapterRepos chapRepo;

    public Chapter addChapter(User intructor, Course course,Chapter chapter){
        if(course.getCreatorId() != intructor.getId()){
            throw new IllegalArgumentException("Only the creator of the coures can add chapter");
        }

        chapter.setCoure(course);
        chapter.setCreator(intructor);
        chapRepo.save(chapter);
        return chapter;
    }

    public Chapter findById(int id) {
        return chapRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Chapter not found"));
    }

    public List<Chapter> getAll(){
        return chapRepo.findAll();
    }
}
