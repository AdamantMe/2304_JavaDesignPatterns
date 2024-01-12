package org.example.simulator.core;

import org.example.simulator.network.Network;

import java.util.List;
import java.util.PriorityQueue;

public class SimulationController {
    // Private static instance of the SimulationController class
    private static SimulationController instance;

    private final PriorityQueue<Event> eventQueue;
    private final Network network;

    // Variable to track data loss
    private int dataLossCount;

    // Private constructor to prevent instantiation from outside
    private SimulationController(List<Event> events, Network network) {
        this.eventQueue = new PriorityQueue<>(events);
        this.network = network;
        this.dataLossCount = 0; // Initialize data loss count
    }

    // Public static method to get the instance
    public static synchronized SimulationController getInstance(List<Event> events, Network network) {
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

    // Method to determine if data loss should be simulated
    private boolean shouldSimulateDataLoss() {
        // Your logic to determine when data loss should occur
        // Example: Simulate data loss 10% of the time
        return Math.random() < 0.1;
    }

    // Public method to handle data loss
    public void handleDataLoss(Event event) {
        // Your logic to handle data loss
        // Example: Increment data loss count and log the event
        dataLossCount++;
        System.out.println("Data loss detected. Event: " + event.toString());
    }

    // Public method to get the data loss count
    public int getDataLossCount() {
        return dataLossCount;
    }

    // Other methods and attributes as needed
}
