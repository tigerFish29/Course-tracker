package com.spring.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        courseRepo.deleteById(courseId);
    }

    @Override
    public void updateCourse(long courseId, Course course) {
       
        courseRepo.findById(courseId).ifPresent(dbCourse -> {
            dbCourse.setName(course.getName());
            dbCourse.setCategory(course.getCategory());
            dbCourse.setDescription(course.getDescription());
            dbCourse.setRating(course.getRating());

            courseRepo.save(dbCourse);
        });
        
    }
    
}
