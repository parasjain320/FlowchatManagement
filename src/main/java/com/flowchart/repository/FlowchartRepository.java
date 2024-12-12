package com.flowchart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flowchart.entity.Flowchart;

public interface FlowchartRepository extends JpaRepository<Flowchart, String> {}

