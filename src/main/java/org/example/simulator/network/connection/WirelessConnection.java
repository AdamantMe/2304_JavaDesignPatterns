package org.example.simulator.network.connection;

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
            this.dataBuffer = data;
            System.out.println("Wirelessly sending data from " + source + " to " + destination + ": " + data);
            // TODO: simulate wireless-specific behaviors, like interference or signal strength issues
        }
    }

    @Override
    public String receivePacket(String destinationId) {
        if (this.destination.equals(destinationId)) {
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
}
