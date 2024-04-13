package com.vmedico.medapp.repository;


import com.vmedico.medapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}

