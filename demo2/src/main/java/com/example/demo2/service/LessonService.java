package com.example.demo2.service;

import com.example.demo2.model.Chapter;
import com.example.demo2.model.Lesson;
import com.example.demo2.model.User;
import com.example.demo2.repository.LessonRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {
    @Autowired
    private LessonRepos lessRepo;

    public Lesson addLesson(User intructor, Chapter chapter,Lesson lesson){
        if(chapter.getCreator().getId() != intructor.getId()){
            throw new IllegalArgumentException("Only the creator of the chapter can add lesson");
        }

        lesson.setChapter(chapter);
        lesson.setCreator(intructor);
        lessRepo.save(lesson);
        return lesson;
    }

    public List<Lesson> getAll(){
        return lessRepo.findAll();
    }

}
