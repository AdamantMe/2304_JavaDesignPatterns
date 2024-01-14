package org.example.simulator.network.device;

import org.example.simulator.network.connection.Connection;
import org.example.simulator.strategy.ActionEvent;
import org.example.simulator.strategy.PacketTransferAction;

public class EndDevice implements Device {
    private final String id;
    private Connection connection;

    public EndDevice(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void receivePacket(String data) {
        ActionEvent event = new ActionEvent(null); // TODO: Add a strategy like in sendPacket
        event.setSource(this.id); // The device itself is the source of the event
        event.setData(data);
        event.execute();
    }

    @Override
    public void connectTo(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void sendPacket(String destinationId, String data) {
        if (connection != null) {
            ActionEvent event = new ActionEvent(new PacketTransferAction());
            event.setSource(this.id);
            event.setDestination(destinationId);
            event.setData(data);
            event.execute();
        } else
        {
            System.out.println("No connection available for device " + getId());
        }
    }
}