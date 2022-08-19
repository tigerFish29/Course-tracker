package com.spring.spring.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.spring.model.Course;

@Repository
public interface CourseRepo extends CrudRepository<Course, Long> {
    Iterable<Course> findAllByCategory(String category);
    
}
