package tn.esprit.chakrounnassim4ds3.services;

import tn.esprit.chakrounnassim4ds3.entities.Course;

import java.util.List;

public interface ICourseServices {

    Course getCourse(long id);
    Course addCourse(Course course);
    Course updateCourse(Course course);
    void deleteCourse(long id);
    List<Course> getAllCourses();
}
