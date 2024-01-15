package org.example.simulator.network.device;

import org.example.simulator.network.connection.Connection;
import org.example.simulator.strategy.ActionEvent;

import java.util.HashMap;
import java.util.Map;

public class Router implements Device {
    private final String id;
    private Connection connection;
    private Map<String, Connection> routingTable;

    public Router(String id) {
        this.id = id;
        this.routingTable = new HashMap<>();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void receivePacket(String data) {
        ActionEvent event = new ActionEvent(null);
        event.setSource(this.id);
        event.setData(data);
        event.execute();
    }

    @Override
    public void sendPacket(String destinationId, String data) {
        if (connection != null) {
            Connection destinationConnection = routingTable.get(destinationId);
            if (destinationConnection != null) {
                destinationConnection.sendPacket(this.id, destinationId, data);
                System.out.println("Router " + id + " sent packet to " + destinationId + " with data: " + data);
            } else {
                System.out.println("Router " + id + " does not have a route to " + destinationId);
            }
        } else {
            System.out.println("Router " + id + " has no connection to send packet to " + destinationId);
        }
    }

    @Override
    public void connectTo(Connection connection) {
        this.connection = connection;
    }

    public void addRoute(String destinationId, Connection connection) {
        routingTable.put(destinationId, connection);
    }
}
