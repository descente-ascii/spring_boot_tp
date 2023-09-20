package dao;

import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoStudent extends JpaRepository<Student, Long> {

}
