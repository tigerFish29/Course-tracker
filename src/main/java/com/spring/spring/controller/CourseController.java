package com.spring.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring.model.Course;
import com.spring.spring.service.CourseService;

@RestController
@RequestMapping("/courses/")
public class CourseController {

    @Autowired
    private CourseService courseService;
    
    // get all courses 
    @GetMapping
    public Iterable<Course> getAllCourses() {
        return courseService.getCourses();
    }

    // get one 
    @GetMapping("{id}")
    public Optional<Course> getCourseById(@PathVariable("id") long courseId) {
        return courseService.getCourseById(courseId);
    }

    @GetMapping("category/{name}")
    public Iterable<Course> getCourseByCategory(@PathVariable("name") String category) {
        return courseService.getCoursesByCategory(category);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    // update the course
    @PutMapping("{id}")
    public void updateCourse(@PathVariable("id") long courseId, @RequestBody Course course) {
        courseService.updateCourse(courseId, course);
    }

    // delete the course 
    @DeleteMapping("{id}")
    void deleteCourseById(@PathVariable("id") long courseId) {
        courseService.deleteCourseById(courseId);
    }

    // delete all 
    @DeleteMapping
    void deleteCourses() {
        courseService.deleteCourses();
    }

    
}
