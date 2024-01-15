package org.example.simulator.network.device;

import org.example.simulator.network.connection.Connection;
import org.example.simulator.strategy.ActionEvent;
import org.example.simulator.strategy.EventActionStrategy;
import org.example.simulator.strategy.PacketTransferAction;
import org.example.simulator.strategy.PacketReceiveAction;

public class EndDevice implements Device {
    private final String id;
    private Connection connection;
    private String macAddress;

    public EndDevice(String id) {
        this.id = id;
    }

    @Override
    public void processPacket(String sourceMac, String destinationMac) {

    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void receivePacket(String data) {
        if (connection != null) {
            // Ensure that PacketReceiveAction implements EventActionStrategy
            EventActionStrategy receiveAction = new PacketReceiveAction();

            // Create an ActionEvent with the receive action
            ActionEvent event = new ActionEvent(receiveAction);
            event.setSource(this.id);
            event.setData(data);
            event.execute();
        } else {
            System.out.println("No connection available for device " + getId());
        }
    }

    @Override
    public void connectTo(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void setMACAddress(String macAddress) {
        this.macAddress = macAddress; // Set the provided MAC address
    }

    @Override
    public String getMACAddress() {
        return macAddress;
    }

    @Override
    public void sendPacket(String destinationId, String data) {
        if (connection != null) {
            ActionEvent event = new ActionEvent(new PacketTransferAction());
            event.setSource(this.id);
            event.setDestination(destinationId);
            event.setData(data);
            event.execute();
        } else {
            System.out.println("No connection available for device " + getId());
        }
    }
}
