package dao;

import domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoAppointment extends JpaRepository<Appointment, Long> {
}
