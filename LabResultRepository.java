package com.vmedico.medapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vmedico.medapp.model.LabResult;

@Repository
public interface LabResultRepository extends JpaRepository<LabResult, Long> {

}