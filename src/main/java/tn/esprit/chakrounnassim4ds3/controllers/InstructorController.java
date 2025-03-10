package tn.esprit.chakrounnassim4ds3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.chakrounnassim4ds3.entities.Instructor;
import tn.esprit.chakrounnassim4ds3.services.IInstructorServices;


import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("instructor")
public class InstructorController {

    private IInstructorServices instructorService;

    @GetMapping("all")
    public List<Instructor> retrieveAll(){
        return instructorService.getAllInstructors();
    }


    @PostMapping("add")
    Instructor addCourse(@RequestBody Instructor instructor) {
        return instructorService.addInstructor(instructor);
    }

    @PutMapping("update")
    Instructor updateCourse(@RequestBody Instructor instructor) {
        return instructorService.updateInstructor(instructor);
    }

    @GetMapping("get/{numInstructor}")
    Instructor retrieveCourse(@PathVariable("numInstructor") Long numCourse) {
        return instructorService.getInstructor(numCourse);
    }

    @DeleteMapping("remove/{numInstructor}")
    void removeCourse(@PathVariable("numInstructor") Long numInstructor) {
        instructorService.deleteInstructor(numInstructor);
    }

    @PostMapping("add/{courseId}")
    Instructor addInstructorAndAssignToCourse(@RequestBody Instructor instructor,@PathVariable Long courseId) {
        return instructorService.addInstructorAndAssignToCourse(instructor, courseId);
    }
}
