// Network.java
package org.example.simulator.network;

import org.example.simulator.core.Event;
import org.example.simulator.network.connection.Connection;
import org.example.simulator.network.device.Device;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Network {
    private Map<String, Device> devices = new HashMap<>();
    private List<Connection> connections = new ArrayList<>();

    public void addDevice(Device device) {
        devices.put(device.getId(), device);
    }

    public Device getDevice(String deviceId) {
        return devices.get(deviceId);
    }

    public void addConnection(Connection connection) {
        connections.add(connection);
    }

    public void processEvent(Event event) {
        try {
            switch (event.getEventType()) {
                case PACKET_TRANSFER:
                    processPacketTransferEvent(event);
                    break;
                case DEVICE_FAILURE:
                    processDeviceFailureEvent(event);
                    break;
                default:
                    System.out.println("Unknown event type.");
            }
        } catch (Exception e) {
            System.out.println("Error processing event: " + e.getMessage());
        }
    }

    private void processPacketTransferEvent(Event event) {
        String sourceId = event.getSource().orElse(null);
        String destinationId = event.getDestination().orElse(null);
        String data = event.getData().orElse(null);

        if (sourceId == null || destinationId == null || data == null) {
            System.out.println("Packet transfer event is missing required information.");
            return;
        }

        Device sourceDevice = getDevice(sourceId);
        Device destinationDevice = getDevice(destinationId);
        Connection connection = getConnectionBetween(sourceId, destinationId);

        if (sourceDevice != null && destinationDevice != null && connection != null) {
            // Device sends packet to connection
            sourceDevice.connectTo(connection);
            connection.sendPacket(sourceId, destinationId, data);

            // Connection 'transmits' the packet
            String receivedData = connection.receivePacket(destinationId);

            // Destination device receives the packet from connection
            if (receivedData != null) {
                destinationDevice.receivePacket(receivedData);
            }
        } else {
            System.out.println("Packet transfer cannot be completed due to missing devices or connection.");
        }
    }

    private void processDeviceFailureEvent(Event event) {
        String deviceId = event.getSource().orElse(null);

        if (deviceId == null) {
            System.out.println("Device failure event is missing required information.");
            return;
        }

        Device failedDevice = getDevice(deviceId);

        if (failedDevice != null) {
            // Simulate device failure
            System.out.println("Device " + deviceId + " has failed.");
            devices.remove(deviceId);
        } else {
            System.out.println("Device failure event cannot be processed due to missing device.");
        }
    }

    public Connection getConnectionBetween(String sourceId, String destinationId) {
        // Loop through the connections list and return the matching connection
        for (Connection conn : connections) {
            if (conn.getSource().equals(sourceId) && conn.getDestination().equals(destinationId)) {
                return conn;
            }
        }
        return null; // No connection found
    }

    public String getNextHop(String source) {
        for (Connection conn : connections) {
            if (conn.getSource().equals(source)) {
                return conn.getDestination();
            }
        }
        return null;
    }

    public void connectDevicesToConnections() {
        for (Connection connection : this.connections) {
            String sourceId = connection.getSource();
            String destinationId = connection.getDestination(); // Assuming two-way connection
            Device sourceDevice = getDevice(sourceId);
            Device destinationDevice = getDevice(destinationId);

            if (sourceDevice != null) {
                sourceDevice.connectTo(connection);
            }
            if (destinationDevice != null) {
                destinationDevice.connectTo(connection); // Optional, based on network design
            }
        }
    }
}
