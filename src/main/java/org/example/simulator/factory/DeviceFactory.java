package org.example.simulator.factory;

import org.example.simulator.network.Device;
import org.example.simulator.network.EndDevice;
import org.example.simulator.network.Router;

import java.util.HashMap;
import java.util.Map;

public class DeviceFactory{
    private Map<String, Class<? extends Device>> deviceTypeRegistry = new HashMap<>();

    public DeviceFactory() {
        // Registering default types allows the factory to create instances of these types dynamically.
        // This makes it easy to add new device types later on, without modifying the factory's internal logic.
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
                // Reflection to create an instance of the device class.
                Device device = deviceClass.getDeclaredConstructor(String.class).newInstance(deviceId);

                return device;
            } catch (Exception e) {
                throw new RuntimeException("Error creating device instance for type " + typeId, e);
            }
        }
        throw new IllegalArgumentException("No registered device type for: " + typeId);
    }
}
