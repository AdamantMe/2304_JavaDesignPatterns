package org.example;

public class DeviceBuilder {

    DeviceFactory factory;

    public void deviceBuilder(DeviceFactory factory) {
        this.factory = factory;
    }

    public Device makeDevice(String type) {
        Device device;
        device = factory.createDevice(type);

        return device;
    }


}
