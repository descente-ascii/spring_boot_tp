package com.taa.app.controller;

import com.taa.app.aop.Supervision;
import com.taa.app.dto.TeacherDTO;
import com.taa.app.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService ;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hey";
    }

    @PostMapping("/create")
    public ResponseEntity<TeacherDTO> createTeacher(@RequestBody TeacherDTO teacherDTO){
        TeacherDTO teacher = teacherService.createTeacher(teacherDTO);
        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

    @Supervision(dureeMillis = 5)
    @PostMapping("/createTooLong")
    public ResponseEntity<TeacherDTO> createTeacherTooLong(@RequestBody TeacherDTO teacherDTO) {
        TeacherDTO teacher = teacherService.createTeacher(teacherDTO);
        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable("id") Long teacherId){
        TeacherDTO teacherDTO = teacherService.getTeacherById(teacherId);
        return ResponseEntity.ok(teacherDTO);
    }

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> getAllTeachers(){
        List<TeacherDTO> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    @PutMapping("{id}")
    public ResponseEntity<TeacherDTO> updateTeacher(@PathVariable("id") Long teacherId,
                                                            @RequestBody TeacherDTO updatedTeacher){
        TeacherDTO teacherDTO = teacherService.updateTeacher(teacherId, updatedTeacher);
        return ResponseEntity.ok(teacherDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable("id") Long teacherId){
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.ok("teacher deleted successfully!.");
    }
    
}
