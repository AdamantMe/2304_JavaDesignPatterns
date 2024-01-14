package org.example.simulator.network.connection;

public class WiredConnection implements Connection {
    private String source;
    private String destination;
    private String dataBuffer;

    public WiredConnection(String source, String destination) {
        this.source = source;
        this.destination = destination;
        this.dataBuffer = null;
    }

    @Override
    public void sendPacket(String sourceId, String destinationId, String data) {
        if (this.source.equals(sourceId) && this.destination.equals(destinationId)) {
            this.dataBuffer = data; // Simulate sending by storing the data in the buffer
            System.out.println("Sending (by wire) data from " + source + " to " + destination + ": " + data);
        }
    }

    @Override
    public String receivePacket(String destinationId) {
        if (this.destination.equals(destinationId)) {
            String dataToReceive = this.dataBuffer; // Simulate receiving by taking data from the buffer
            this.dataBuffer = null; // Clear the buffer
            System.out.println("Received (by wire) data at " + destination + ": " + dataToReceive);
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
}
