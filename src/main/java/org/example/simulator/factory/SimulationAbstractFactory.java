package org.example.simulator.factory;

public interface SimulationAbstractFactory {
    DeviceFactory getDeviceFactory();
    ConnectionFactory getConnectionFactory();
    EventFactory getEventFactory();
}
