package org.example.simulator.network.device;

import org.example.simulator.network.connection.Connection;
import org.example.simulator.strategy.ActionEvent;

public class Router implements Device {
    private final String id;
    private Connection connection; // TODO: add the logic for routing table

    public Router(String id) {
        this.id = id;
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
            connection.sendPacket(this.id, destinationId, data);
            System.out.println("Router " + id + " sent packet to " + destinationId + " with data: " + data);
        } else {
            System.out.println("Router " + id + " has no connection to send packet to " + destinationId);
        }
    }

    @Override
    public void connectTo(Connection connection) {
        this.connection = connection;
    }
}
