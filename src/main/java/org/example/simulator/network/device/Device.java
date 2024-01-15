package org.example.simulator.network.device;

import org.example.simulator.network.connection.Connection;

public interface Device {
    void processPacket(String sourceMac, String destinationMac);

    String getId();
    void receivePacket(String data);
    void sendPacket(String destinationId, String data);
    void connectTo(Connection connection);
}