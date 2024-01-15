package org.example.simulator.core;

import org.example.simulator.network.Network;

import java.util.List;
import java.util.PriorityQueue;

public class SimulationController {
    private static SimulationController instance;

    private final PriorityQueue<Event> eventQueue;
    private final Network network;
    private int dataLossCount; // TODO: collect data loss from each event - move into new object?

    private SimulationController(List<Event> events, Network network) {
        this.eventQueue = new PriorityQueue<>(events);
        this.network = network;
        this.dataLossCount = 0;
    }

    public static SimulationController getInstance(List<Event> events, Network network) {
        if (instance == null) {
            instance = new SimulationController(events, network);
        }
        return instance;
    }

    public void runSimulation() {
        while (!eventQueue.isEmpty()) {
            Event currentEvent = eventQueue.poll();

            // Simulate data loss
            if (shouldSimulateDataLoss()) {
                handleDataLoss(currentEvent);
            } else {
                network.processEvent(currentEvent);
            }
        }
    }

    private boolean shouldSimulateDataLoss() { //TODO change this
        // Data loss is simulated 10% of the time
        return Math.random() < 0.1;
    }

    public void handleDataLoss(Event event) { // TODO change this
        dataLossCount++;
        System.out.println("Data loss detected. Event: " + event.toString());
        System.out.println("Total data loss count: " + dataLossCount);
    }


    public int getDataLossCount() {
        return dataLossCount;
    }//TODO change this
}
