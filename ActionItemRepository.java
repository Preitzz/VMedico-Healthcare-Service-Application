package com.vmedico.medapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vmedico.medapp.model.ActionItem;

public interface ActionItemRepository extends JpaRepository<ActionItem, Long> {
}
