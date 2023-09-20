package dao;

import domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoTeacher extends JpaRepository<Teacher, Long> {
}
