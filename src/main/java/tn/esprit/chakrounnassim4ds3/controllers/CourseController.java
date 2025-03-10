package tn.esprit.chakrounnassim4ds3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.chakrounnassim4ds3.entities.Course;
import tn.esprit.chakrounnassim4ds3.services.ICourseServices;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("course")
public class CourseController {

    private ICourseServices courseService;

    @GetMapping("all")
    public List<Course> retrieveAll(){
        return courseService.getAllCourses();
    }


    @PostMapping("add")
    Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @PutMapping("update")
    Course updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }

    @GetMapping("get/{numCourse}")
    Course retrieveCourse(@PathVariable("numCourse") Long numCourse) {
        return courseService.getCourse(numCourse);
    }

    @DeleteMapping("remove/{numCourse}")
    void removeCourse(@PathVariable("numCourse") Long numCourse) {
        courseService.deleteCourse(numCourse);
    }
}
