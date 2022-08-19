package com.spring.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.spring.exception.courseNotFound;
import com.spring.spring.model.Course;
import com.spring.spring.repo.CourseRepo;

@Service
public class CourseServiceImp implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public Course createCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public Optional<Course> getCourseById(long courseId) {
        return courseRepo.findById(courseId);
    }

    @Override
    public Iterable<Course> getCoursesByCategory(String category) {
        return courseRepo.findAllByCategory(category);
    }

    @Override
    public Iterable<Course> getCourses() {
        return courseRepo.findAll();
    }

    

    @Override
    public void deleteCourses() {
        courseRepo.deleteAll();
    }

    @Override 
    public void deleteCourseById(long courseId) {
        courseRepo.findById(courseId).orElseThrow(() -> new courseNotFound("Course not found"));
        courseRepo.deleteById(courseId);
    }
    
    @Override
    public Course updateCourse(long courseId, Course course) {
        Course exists = courseRepo.findById(courseId)
        .orElseThrow(() -> new courseNotFound(String.format("Course with id %s could not be found ", courseId)));
        exists.setName(course.getName());
        exists.setCategory(course.getCategory());
        exists.setDescription(course.getDescription());
        exists.setRating(course.getRating());
        return courseRepo.save(exists);
    }
    
}
