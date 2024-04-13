package com.vmedico.medapp.controller;

import com.vmedico.medapp.model.Patient;
import com.vmedico.medapp.service.PatientService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.findAllPatients();
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return patientService.findPatientById(id)
                .map(patient -> ResponseEntity.ok(patient))
                .orElse(ResponseEntity.notFound().build());
    }

 
    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.savePatient(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

  
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
        return patientService.findPatientById(id)
                .map(patient -> {
                    patient.setName(patientDetails.getName());
                    patient.setEmail(patientDetails.getEmail());
                    patient.setPhoneNumber(patientDetails.getPhoneNumber());
                    // ... other fields to update
                    Patient updatedPatient = patientService.savePatient(patient);
                    return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        return patientService.findPatientById(id)
                .map(patient -> {
                    patientService.deletePatient(id);
                    return new ResponseEntity<Void>(HttpStatus.OK);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
