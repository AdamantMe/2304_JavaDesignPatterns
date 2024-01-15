package org.example.simulator.network.connection;

import org.example.simulator.network.connection.Connection;

import java.util.Random;

public class WirelessConnection implements Connection {
    private String source;
    private String destination;
    private String dataBuffer;

    public WirelessConnection(String source, String destination) {
        this.source = source;
        this.destination = destination;
        this.dataBuffer = null;
    }

    @Override
    public void sendPacket(String sourceId, String destinationId, String data) {
        if (this.source.equals(sourceId) && this.destination.equals(destinationId)) {
            if (isPacketLost()) {
                System.out.println("Packet lost while sending data from " + source + " to " + destination);
                return;
            }
            
            this.dataBuffer = data;
            System.out.println("Wirelessly sending data from " + source + " to " + destination + ": " + data);
        }
    }

    @Override
    public String receivePacket(String destinationId) {
        if (this.destination.equals(destinationId)) {
            if (isPacketCorrupted()) {
                System.out.println("Received data at " + destination + " is corrupted.");
                return null;
            }
            
            String dataToReceive = this.dataBuffer;
            this.dataBuffer = null;
            System.out.println("Wirelessly received data at " + destination + ": " + dataToReceive);
            return dataToReceive;
        }
        return null;
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    // Simulate packet loss with a 10% probability
    private boolean isPacketLost() {
        Random random = new Random();
        return random.nextDouble() < 0.1;
    }

    // Simulate packet corruption with a 5% probability
    private boolean isPacketCorrupted() {
        Random random = new Random();
        return random.nextDouble() < 0.05;
    }
}
