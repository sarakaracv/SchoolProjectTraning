package com.cydeo.service;


import com.cydeo.entity.Course;

import java.util.List;

import static com.cydeo.database.Database.courseList;


public class CourseService implements CRUDService<Course>{

    @Override
    public Course findById(int id) {
        return  courseList.stream()
                .filter(course -> course.id == id)
                .findFirst().orElseThrow();

    }

    @Override
    public List<Course> findAll() {
        return courseList;

    }

    @Override
    public void save(Course o) {
        courseList.add((Course)o);
    }

    @Override
    public void update(Course o) {
        for (Course course : courseList) {
            if (course.getId() == o.getId()) {
                course.setCourseDay(o.getCourseDay());
                course.setName(o.getName());
                course.setMinScore(o.getMinScore());
            }
        }

    }

    @Override
    public void deleteById(Long id) {
        courseList.removeIf(course -> course.id == id);
    }
}
