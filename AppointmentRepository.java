package com.vmedico.medapp.repository;



import com.vmedico.medapp.model.Appointment;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("SELECT a FROM Appointment a WHERE a.date BETWEEN :start AND :end")
    List<Appointment> findUpcomingAppointments(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
