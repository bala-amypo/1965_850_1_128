package sbs.rosedev.springFirst.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sbs.rosedev.springFirst.entity.StudentEntity;
import sbs.rosedev.springFirst.services.StudentService;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/postStudentData")
    public StudentEntity postStudentData(@RequestBody StudentEntity entity) {
        return studentService.addRecord(entity);
    }

    @GetMapping("/getStudentData")
    public List<StudentEntity> getStudentData() {
        return studentService.getRecords();
    }
    
    @GetMapping("/getStudentId/{id}")
    public StudentEntity getStudentId(@PathVariable int id) {
        return studentService.getStudentRecord(id);
    }

    @PutMapping("/updateStudentRecord/{id}")
    public StudentEntity updateStudentData(@PathVariable int id, @RequestBody StudentEntity entity) {
        return studentService.updateStudentRecord(id, entity);
    }

    @DeleteMapping("/deleteStudentRecord/{id}")
    public String deleteStudentData(@PathVariable int id) {
        return studentService.deleteStudentRecord(id);
    }

}
