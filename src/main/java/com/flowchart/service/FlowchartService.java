package com.flowchart.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowchart.entity.Edge;
import com.flowchart.entity.Flowchart;
import com.flowchart.repository.EdgeRepository;
import com.flowchart.repository.FlowchartRepository;
import com.flowchart.repository.NodeRepository;

@Service
public class FlowchartService {

    @Autowired
    private FlowchartRepository flowchartRepository;

    @Autowired
    private NodeRepository nodeRepository;

    @Autowired
    private EdgeRepository edgeRepository;

    public Flowchart createFlowchart(Flowchart flowchart) {
        return flowchartRepository.save(flowchart);
    }

    public Flowchart getFlowchart(String id) {
        return flowchartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flowchart not found"));
    }

    public Flowchart updateFlowchart(String id, Flowchart updatedFlowchart) {
        Flowchart flowchart = getFlowchart(id);

        flowchart.getNodes().clear();
        flowchart.getNodes().addAll(updatedFlowchart.getNodes());

        flowchart.getEdges().clear();
        flowchart.getEdges().addAll(updatedFlowchart.getEdges());

        return flowchartRepository.save(flowchart);
    }

    public void deleteFlowchart(String id) {
        flowchartRepository.deleteById(id);
    }

    public List<Edge> getOutgoingEdges(String flowchartId, String nodeId) {
        return edgeRepository.findBySourceNodeAndFlowchartId(nodeId, flowchartId);
    }

    public List<String> getConnectedNodes(String flowchartId, String nodeId) {
        Set<String> visited = new HashSet<>();
        traverseGraph(nodeId, flowchartId, visited);
        return new ArrayList<>(visited);
    }

    private void traverseGraph(String nodeId, String flowchartId, Set<String> visited) {
        if (visited.contains(nodeId)) return;
        visited.add(nodeId);
        List<Edge> outgoingEdges = getOutgoingEdges(flowchartId, nodeId);
        for (Edge edge : outgoingEdges) {
            traverseGraph(edge.getTargetNode(), flowchartId, visited);
        }
    }
}

