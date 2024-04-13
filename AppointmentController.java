package com.vmedico.medapp.controller;

import com.vmedico.medapp.model.Appointment;
import com.vmedico.medapp.service.AppointmentService;
import com.vmedico.medapp.service.EmailService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {private final AppointmentService appointmentService;
private final EmailService emailService;


public AppointmentController(AppointmentService appointmentService, EmailService emailService) {
    this.appointmentService = appointmentService;
    this.emailService = emailService;
}

@GetMapping
public List<Appointment> getAllAppointments() {
    return appointmentService.findAllAppointments();
}

@GetMapping("/{id}")
public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
    return appointmentService.findAppointmentById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
}

@PostMapping
public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
    Appointment savedAppointment = appointmentService.saveAppointment(appointment);

    // Immediately send a reminder email after saving the appointment
    String email = savedAppointment.getPatient().getEmail();
    String subject = "Appointment Confirmation";
    String text = "Dear " + savedAppointment.getPatient().getName() + ",\n\n" +
                  "This is a confirmation for your appointment on " +
                  savedAppointment.getDate().toString() + ".\n\n" +
                  "Regards,\n" +
                  "Your Clinic Name";
    
    emailService.sendAppointmentReminder(email, subject, text);

    return ResponseEntity.status(HttpStatus.CREATED).body(savedAppointment);
}

@PutMapping("/{id}")
public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
    return appointmentService.findAppointmentById(id)
            .map(existingAppointment -> {
                existingAppointment.setPatient(appointment.getPatient());
                existingAppointment.setDoctor(appointment.getDoctor());
                existingAppointment.setAppointmentTime(appointment.getAppointmentTime());
                existingAppointment.setReason(appointment.getReason());
                Appointment updatedAppointment = appointmentService.saveAppointment(existingAppointment);
                return ResponseEntity.ok(updatedAppointment);
            })
            .orElseGet(()
            		-> ResponseEntity.notFound().build());
            		}@DeleteMapping("/{id}")
            		public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
            		    appointmentService.deleteAppointment(id);
            		    return ResponseEntity.ok().build();
            		}
}
