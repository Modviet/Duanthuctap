package com.example.demo2.service;


import com.example.demo2.model.Course;
import com.example.demo2.model.User;
import com.example.demo2.repository.CourseRepos;
import com.example.demo2.repository.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseService {

    @Autowired
    private CourseRepos courRepo;

    @Autowired
    private UserRepos userRepo;

    @Autowired
    private NotificationService notiService;

    public Course addCourse(int userId,Course course){
        User user = userRepo.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("User not found"));

        if(!IsInstructor(user)){
            throw new IllegalArgumentException("User is not have instructor certificate");
        }

        course.setCreatorId(userId);
        Course newCourse = courRepo.save(course);

        List<User> students = getPreviousStudent(userId);
        String content = "New course add by your instructor" + course.getName();
        String link = "/course/"+ course.getId();
        notiService.notifyStudents(students,content,link);
        return newCourse;
    }

    public List<User> getPreviousStudent(int usedId){
        return userRepo.findStudentsById(usedId);
    }

    private boolean IsInstructor(User user){
        return user.getCertificateId() !=null &&
                  user.getCertificateId().getCertificateTypeId().getName().equals("Giang vien");
    }

    public Course findById(int id) {
        return courRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));
    }

    public List<Course> getAll(){
        return courRepo.findAll();
    }
}
