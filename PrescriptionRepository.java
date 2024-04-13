package com.vmedico.medapp.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vmedico.medapp.model.Prescription;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

}