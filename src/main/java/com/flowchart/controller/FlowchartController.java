package com.flowchart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flowchart.entity.Edge;
import com.flowchart.entity.Flowchart;
import com.flowchart.service.FlowchartService;

@RestController
@RequestMapping("/flowcharts")
public class FlowchartController {

    @Autowired
    private FlowchartService flowchartService;

    @PostMapping
    public ResponseEntity<Flowchart> createFlowchart(@RequestBody Flowchart flowchart) {
        return ResponseEntity.ok(flowchartService.createFlowchart(flowchart));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flowchart> getFlowchart(@PathVariable String id) {
        return ResponseEntity.ok(flowchartService.getFlowchart(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flowchart> updateFlowchart(
            @PathVariable String id,
            @RequestBody Flowchart updatedFlowchart) {
        return ResponseEntity.ok(flowchartService.updateFlowchart(id, updatedFlowchart));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFlowchart(@PathVariable String id) {
        flowchartService.deleteFlowchart(id);
        return ResponseEntity.ok("Flowchart deleted");
    }

    @GetMapping("/{id}/edges/{nodeId}")
    public ResponseEntity<List<Edge>> getOutgoingEdges(
            @PathVariable String id,
            @PathVariable String nodeId) {
        return ResponseEntity.ok(flowchartService.getOutgoingEdges(id, nodeId));
    }

    @GetMapping("/{id}/connected/{nodeId}")
    public ResponseEntity<List<String>> getConnectedNodes(
            @PathVariable String id,
            @PathVariable String nodeId) {
        return ResponseEntity.ok(flowchartService.getConnectedNodes(id, nodeId));
    }
}
