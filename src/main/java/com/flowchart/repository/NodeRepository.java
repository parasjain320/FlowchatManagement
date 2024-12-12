package com.flowchart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.flowchart.entity.Node;

public interface NodeRepository extends JpaRepository<Node, String> {}

