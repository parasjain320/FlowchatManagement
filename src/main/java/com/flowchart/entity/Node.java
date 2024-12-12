package com.flowchart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Node {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "flowchart_id")
    private Flowchart flowchart;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Flowchart getFlowchart() {
		return flowchart;
	}

	public void setFlowchart(Flowchart flowchart) {
		this.flowchart = flowchart;
	}

    // Getters and Setters
    
    
}
