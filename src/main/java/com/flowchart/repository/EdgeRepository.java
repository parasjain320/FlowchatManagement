package com.flowchart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flowchart.entity.Edge;

public interface EdgeRepository extends JpaRepository<Edge, Long> {
    List<Edge> findBySourceNodeAndFlowchartId(String sourceNode, String flowchartId);
}

