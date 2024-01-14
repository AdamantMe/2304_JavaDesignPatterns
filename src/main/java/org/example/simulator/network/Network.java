// Network.java
package org.example.simulator.network;

import org.example.simulator.core.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Network {
    private Map<String, Device> devices = new HashMap<>();
    private List<Connection> connections = new ArrayList<>();

    public void addDevice(Device device) {
        devices.put(device.getId(), device);
    }

    public Device getDevice(String deviceId) {
        return devices.get(deviceId);
    }

    public void addConnection(Connection connection) {
        connections.add(connection);
    }

    public void processEvent(Event event) {
        try {
            switch (event.getEventType()) {
                case PACKET_TRANSFER:
                    processPacketTransferEvent(event);
                    break;
                case DEVICE_FAILURE:
                    // TODO: Add logic for handling device failure
                    break;
                default:
                    System.out.println("Unknown event type.");
            }
        } catch (Exception e) {
            System.out.println("Error processing event: " + e.getMessage());
        }
    }

    private void processPacketTransferEvent(Event event) {
        // Extracting necessary information from the event
        String sourceId = event.getSource().orElse(null);
        String destinationId = event.getDestination().orElse(null);
        String data = event.getData().orElse(null);

        if (sourceId == null || destinationId == null || data == null) {
            System.out.println("Packet transfer event is missing required information.");
            return;
        }

        // Forward the packet through the network from source to destination
        String currentDeviceId = sourceId;
        while (!currentDeviceId.equals(destinationId)) {
            String nextDeviceId = getNextHop(currentDeviceId);

            if (nextDeviceId == null) {
                System.out.println("No connection found from " + currentDeviceId);
                break;
            }

            Device currentDevice = devices.get(currentDeviceId);
            if (currentDevice != null) {
                currentDevice.sendPacket(nextDeviceId, data);
            } else {
                System.out.println("Device not found: " + currentDeviceId);
                break;
            }

            currentDeviceId = nextDeviceId;
        }
    }

    public String getNextHop(String source) {
        for (Connection conn : connections) {
            if (conn.getSource().equals(source)) {
                return conn.getDestination();
            }
        }
        return null;
    }
}
