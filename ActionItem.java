package com.vmedico.medapp.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class ActionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private boolean isCompleted;

    @Temporal(TemporalType.DATE)
    private Date dueDate;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

    // Constructors, getters, and setters
}
