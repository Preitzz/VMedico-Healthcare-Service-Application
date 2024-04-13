package com.vmedico.medapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vmedico.medapp.model.Prescription;
import com.vmedico.medapp.service.PrescriptionService;

import java.util.List;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping
    public ResponseEntity<List<Prescription>> getAllPrescriptions() {
        List<Prescription> prescriptions = prescriptionService.getAllPrescriptions();
        return new ResponseEntity<>(prescriptions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable Long id) {
        Prescription prescription = prescriptionService.getPrescriptionById(id);
        return new ResponseEntity<>(prescription, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Prescription> addPrescription
    (@RequestBody Prescription prescription) {
    	Prescription newPrescription = prescriptionService.saveOrUpdatePrescription(prescription);
    	return new ResponseEntity<>(newPrescription, HttpStatus.CREATED);
    	}
    @PutMapping("/{id}")
    public ResponseEntity<Prescription> updatePrescription(@PathVariable Long id, @RequestBody Prescription prescription) {
        Prescription updatePrescription = prescriptionService.saveOrUpdatePrescription(prescription);
        return new ResponseEntity<>(updatePrescription, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePrescription(@PathVariable Long id) {
        prescriptionService.deletePrescription(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
