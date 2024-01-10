package org.example.simulator.network;

public class EndDevice implements Device {
    private final String id;

    public EndDevice(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void receivePacket(String data) {
        System.out.println("Device " + id + " received packet with data: " + data);
    }

    @Override
    public void sendPacket(String destinationId, String data) {
        System.out.println("Device " + id + " sending packet to " + destinationId + " with data: " + data);
    }
}