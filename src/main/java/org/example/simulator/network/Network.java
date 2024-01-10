package org.example.simulator.network;

import org.example.simulator.core.Event;

import java.util.HashMap;
import java.util.Map;

public class Network {
    private Map<String, Device> devices = new HashMap<>();
    private Map<String, String> connections = new HashMap<>();

    public void addDevice(Device device) {
        devices.put(device.getId(), device);
    }

    public Device getDevice(String deviceId) {
        return devices.get(deviceId);
    }

    public void addConnection(String source, String destination) {
        connections.put(source, destination);
    }

    public void processEvent(Event event) {
        try {
            if (event.getEventType() == Event.EventType.PACKET_TRANSFER) {
                if (event.getSource().isPresent() && event.getDestination().isPresent() && event.getData().isPresent()) {
                    String sourceId = event.getSource().get();
                    String destinationId = event.getDestination().get();
                    String data = event.getData().get();

                    // Forward the packet, according to the connections described in the JSON, until it reaches the destination.
                    String nextHop = sourceId;
                    while (!nextHop.equals(destinationId)) {
                        if (connections.containsKey(nextHop)) {
                            String finalNextHop = nextHop;
                            nextHop = connections.get(nextHop);
                            devices.get(finalNextHop).sendPacket(nextHop, data);
                        } else {
                            System.out.println("No connection found from " + nextHop);
                            break;
                        }
                    }
                } else {
                    System.out.println("Packet transfer event is missing required information.");
                }
            }
            else if (event.getEventType() == Event.EventType.DEVICE_FAILURE) {
                // TODO: Add logic for handling device failure
            }
        } catch (Exception e) {
            System.out.println("Error processing event: " + e.getMessage());
        }
    }
}