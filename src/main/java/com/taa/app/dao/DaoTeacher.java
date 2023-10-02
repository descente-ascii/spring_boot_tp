package com.taa.app.dao;

import com.taa.app.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoTeacher extends JpaRepository<Teacher, Long> {
}
