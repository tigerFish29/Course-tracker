package com.spring.spring.service;

import java.util.Optional;

import com.spring.spring.model.Course;

public interface CourseService {

    Course createCourse(Course course);

    Optional<Course> getCourseById(long course);

    Iterable<Course> getCoursesByCategory(String category);

    Iterable<Course> getCourses();

    void updateCourse(long courseId, Course course);

    void deleteCourseById(long courseId);

    void deleteCourses();
    
}
