// Switch.java
package org.example.simulator.network.device;

import org.example.simulator.network.CAMtable;
import org.example.simulator.network.connection.Connection;
import org.example.simulator.network.Network;

public class Switch implements Device {
    private CAMtable camTable;
    private final String id;

    public Switch(String id) {
        this.id = id;
        this.camTable = new CAMtable();
    }

    @Override
    public void processPacket(String sourceMac, String destinationMac) {
        String destinationPort = camTable.getPort(destinationMac);

        if (destinationPort != null) {
            System.out.println("Switch: Forwarding packet from " + sourceMac + " to " + destinationMac + " via port " + destinationPort);

            Device destinationDevice = Network.getInstance().getDevice(destinationMac);
            if (destinationDevice != null) {
                Connection connection = Network.getInstance().getConnectionBetween(this.getId(), destinationDevice.getId());
                if (connection != null) {
                    connectTo(connection);
                    connection.sendPacket(this.getId(), destinationDevice.getId(), "Forwarded packet");
                    String receivedData = connection.receivePacket(destinationDevice.getId());
                    if (receivedData != null) {
                        destinationDevice.receivePacket(receivedData);
                    }
                } else {
                    System.out.println("Switch: Could not find connection to destination device.");
                }
            } else {
                System.out.println("Switch: Destination device not found.");
            }
        } else {
            // Flood the packet (broadcast to all ports)
            System.out.println("Switch: MAC address " + destinationMac + " not found in CAM table. Flooding the packet.");
        }
    }

    @Override
    public String getId() {
        return "Switch1";
    }

    @Override
    public void receivePacket(String data) {
        System.out.println("Switch: Received data - " + data);
    }

    @Override
    public void sendPacket(String destinationId, String data) {
        System.out.println("Switch: Cannot send packet directly. Use processPacket for forwarding.");
    }

    @Override
    public void connectTo(Connection connection) {
        System.out.println("Switch: Connected to " + connection);
    }
}