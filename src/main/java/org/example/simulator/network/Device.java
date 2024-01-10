package org.example.simulator.network;

public interface Device {
    String getId();
    void receivePacket(String data);
    void sendPacket(String destinationId, String data);
}