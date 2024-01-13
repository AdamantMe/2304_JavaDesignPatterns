package org.example;

public class DeviceFactory {
    public Device createDevice(String type) {
        Device device = null;

        if (type.equals("end")) {
            device = new EndDevice();
        } else if (type.equals("switch")) {
            device = new Switch();
        } else if (type.equals("router")) {
            device = new Router();
        }

        return device;
    }
}
