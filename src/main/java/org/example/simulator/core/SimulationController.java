package org.example.simulator.core;

import org.example.simulator.network.Network;

import java.util.List;
import java.util.PriorityQueue;

public class SimulationController {
    private final PriorityQueue<Event> eventQueue;
    private final Network network;

    public SimulationController(List<Event> events, Network network) {
        this.eventQueue = new PriorityQueue<>(events);
        this.network = network;
    }

    public void runSimulation() {
        while (!eventQueue.isEmpty()) {
            Event currentEvent = eventQueue.poll();
            network.processEvent(currentEvent);
        }
    }
}