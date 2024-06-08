package com.example.demo2.controller;




import com.example.demo2.model.Course;
import com.example.demo2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

     @Autowired
     private CourseService courService;

     @PostMapping("/add-course")
    public ResponseEntity<Course> addCourse(@RequestParam int userId,@RequestBody Course course){
         Course newCourse = courService.addCourse(userId, course);
         return ResponseEntity.ok(newCourse);
     }

}
