package com.taa.app.dao;

import com.taa.app.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentDAO extends JpaRepository<Appointment, Long> {
}
