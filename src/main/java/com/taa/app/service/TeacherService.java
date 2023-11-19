package com.taa.app.service;

import com.taa.app.dao.TeacherDAO;
import com.taa.app.domain.Teacher;
import com.taa.app.dto.TeacherDTO;
import com.taa.app.exceptionManager.ResourceNotFoundException;
import com.taa.app.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    @Autowired
    private TeacherDAO teacherDAO;

    public TeacherDTO createTeacher(TeacherDTO teacherDTO){
        System.out.println("---------------------" + teacherDTO.getTeacherName());
        Teacher teacher = TeacherMapper.MAPPER.teacherDTOToTeacher(teacherDTO);
        Teacher savedTeacher = teacherDAO.save(teacher);
        return TeacherMapper.MAPPER.teacherToTeacherDTO(savedTeacher);
    }

    public TeacherDTO getTeacherById(Long teacherId){
        Teacher teacher = teacherDAO.findById(teacherId).orElseThrow(
                () -> new ResourceNotFoundException("Teacher does not exist with the given id: " + teacherId)
        );
        return TeacherMapper.MAPPER.teacherToTeacherDTO(teacher);
    }

    public void deleteTeacher(Long teacherId){
        teacherDAO.findById(teacherId).orElseThrow(
                () -> new ResourceNotFoundException("Teacher does not exist with the given id: " + teacherId)
        );
        teacherDAO.deleteById(teacherId);
    }

    public List<TeacherDTO> getAllTeachers(){
        List<Teacher> teachers = teacherDAO.findAll();
        return teachers.stream().map((teacher) -> TeacherMapper.MAPPER.teacherToTeacherDTO(teacher))
                .collect(Collectors.toList());
    }

    public TeacherDTO updateTeacher(Long teacherId, TeacherDTO updatedTeacher){
        Teacher teacher = teacherDAO.findById(teacherId).orElseThrow(
                () -> new ResourceNotFoundException("Teahcer does not exist with the given id: "+ teacherId)
        );
        teacher.setLaboratory(updatedTeacher.getTeacherLaboratory());
        teacher.setName(updatedTeacher.getTeacherName());
        /*teacher.setStudent(updatedTeacher.getStudentId());
        teacher.setTeacher(updatedTeacher.getTeacherId());*/
        Teacher savedTeacher = teacherDAO.save(teacher);
        return TeacherMapper.MAPPER.teacherToTeacherDTO(savedTeacher);
    }
}
