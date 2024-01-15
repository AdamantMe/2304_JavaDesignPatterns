package org.example.simulator.network.connection;

public class DataCorruptionDecorator implements ConnectionDecorator {
    private ConnectionDecorator decoratedConnection; // Change this to ConnectionDecorator
    private int dataLossCount;
    private boolean result;

    public DataCorruptionDecorator(ConnectionDecorator decoratedConnection) { // Change the parameter type
        this.decoratedConnection = decoratedConnection;
        this.dataLossCount = 0;
        this.result = true;
    }


    @Override
    public void sendPacket(String sourceId, String destinationId, String data) {
        // Some Logic would go here
        decoratedConnection.sendPacket(sourceId, destinationId, data);
    }

    @Override
    public String receivePacket(String destinationId) {
        // Some Logic would go here
        return decoratedConnection.receivePacket(destinationId);
    }

    @Override
    public int getDataLossCount() {
        return 0;
    }

    @Override
    public boolean getResult() {
        return false;
    }

    @Override
    public String getSource() {
        return decoratedConnection.getSource();
    }

    @Override
    public String getDestination() {
        return decoratedConnection.getDestination();
    }
}