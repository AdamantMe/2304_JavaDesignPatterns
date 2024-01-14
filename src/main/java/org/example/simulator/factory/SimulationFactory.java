package org.example.simulator.factory;

public class SimulationFactory implements SimulationAbstractFactory {

    // Final member variables to hold the single instances of each factory.
    private final DeviceFactory deviceFactory;
    private final ConnectionFactory connectionFactory;
    private final EventFactory eventFactory;

    public SimulationFactory() {
        // Initialize each factory exactly once in the constructor.
        this.deviceFactory = new DeviceFactory();
        this.connectionFactory = new ConnectionFactory();
        this.eventFactory = new EventFactory();
    }

    @Override
    public DeviceFactory getDeviceFactory() {
        return deviceFactory;
    }

    @Override
    public ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

    @Override
    public EventFactory getEventFactory() {
        return eventFactory;
    }
}
