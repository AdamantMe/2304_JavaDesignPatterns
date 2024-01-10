package org.example.simulator.network;

import java.util.HashMap;
import java.util.Map;

public class DeviceFactory {
    private Map<String, Class<? extends Device>> deviceTypeRegistry = new HashMap<>();

    public DeviceFactory() {
        // Register default device types.
        registerDeviceType("EndDevice", EndDevice.class);
        registerDeviceType("Router", Router.class);
    }

    public void registerDeviceType(String typeName, Class<? extends Device> deviceType) {
        deviceTypeRegistry.put(typeName, deviceType);
    }

    public Device createDevice(String typeId, String deviceId) {
        Class<? extends Device> deviceClass = deviceTypeRegistry.get(typeId);
        if (deviceClass != null) {
            try {
                Device device = deviceClass.getDeclaredConstructor(String.class).newInstance(deviceId);

                return device;
            } catch (Exception e) {
                throw new RuntimeException("Error creating device instance for type " + typeId, e);
            }
        }
        throw new IllegalArgumentException("No registered device type for: " + typeId);
    }
}
