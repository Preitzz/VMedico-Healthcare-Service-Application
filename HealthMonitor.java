package com.vmedico.medapp.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class HealthMonitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;

    private Double temperature;
    private Double bloodPressure;
    private Double heartRate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date recordedAt;

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(Double bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public Double getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(Double heartRate) {
		this.heartRate = heartRate;
	}

  
}

