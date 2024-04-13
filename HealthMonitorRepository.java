package com.vmedico.medapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vmedico.medapp.model.HealthMonitor;

public interface HealthMonitorRepository extends JpaRepository<HealthMonitor, Long> {
}
