package com.taa.app.dao;

import com.taa.app.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoStudent extends JpaRepository<Student, Long> {

}
