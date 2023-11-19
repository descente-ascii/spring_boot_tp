package com.taa.app.service;

import com.taa.app.dao.StudentDAO;
import com.taa.app.domain.Student;
import com.taa.app.dto.StudentDTO;
import com.taa.app.exceptionManager.ResourceNotFoundException;
import com.taa.app.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public StudentDTO createStudent(StudentDTO studentDTO){
        System.out.println("---------------------" + studentDTO.getStudentName());
        Student student = StudentMapper.MAPPER.studentDTOToStudent(studentDTO);
        Student savedStudent = studentDAO.save(student);
        return StudentMapper.MAPPER.studentToStudentDTO(savedStudent);
    }

    public StudentDTO getStudentById(Long studentId){
        Student student = studentDAO.findById(studentId).orElseThrow(
                () -> new ResourceNotFoundException("Student does not exist with the given id: " + studentId)
        );
        return StudentMapper.MAPPER.studentToStudentDTO(student);
    }

    public void deleteStudent(Long studentId){
        studentDAO.findById(studentId).orElseThrow(
                () -> new ResourceNotFoundException("Student does not exist with the given id: " + studentId)
        );
        studentDAO.deleteById(studentId);
    }

    public List<StudentDTO> getAllStudents(){
        List<Student> students = studentDAO.findAll();
        return students.stream().map((student) -> StudentMapper.MAPPER.studentToStudentDTO(student))
                .collect(Collectors.toList());
    }

    public StudentDTO updateStudent(Long studentId, StudentDTO updatedStudent){
        Student student = studentDAO.findById(studentId).orElseThrow(
                () -> new ResourceNotFoundException("Student does not exist with the given id: "+ studentId)
        );
        student.setStudentNumber(updatedStudent.getStudentNumber());
        student.setName(updatedStudent.getStudentName());
        /*student.setStudent(updatedStudent.getStudentId());
        student.setTeacher(updatedStudent.getTeacherId());*/
        Student savedStudent = studentDAO.save(student);
        return StudentMapper.MAPPER.studentToStudentDTO(savedStudent);
    }

}
