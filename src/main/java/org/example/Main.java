package org.example;

import org.example.simulator.core.Event;
import org.example.simulator.core.SimulationController;
import org.example.simulator.factory.SimulationAbstractFactory;
import org.example.simulator.factory.SimulationFactory;
import org.example.simulator.network.Network;
import org.example.simulator.utils.JsonParser;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            String jsonFilePath = "src/main/resources/simulation_config.json";
            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            JSONObject jsonObject = new JSONObject(jsonContent);

            SimulationAbstractFactory factory = new SimulationFactory();
            Network network = JsonParser.parseNetwork(jsonObject, factory.getDeviceFactory(), factory.getConnectionFactory());
            List<Event> events = JsonParser.parseEvents(jsonObject.getJSONArray("events"), factory.getEventFactory());

            SimulationController simulationController = SimulationController.getInstance(events, network);
            simulationController.runSimulation();

            System.out.println("Total data loss count: " + simulationController.getDataLossCount());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to run the simulation: " + e.getMessage());
        }
    }
}
