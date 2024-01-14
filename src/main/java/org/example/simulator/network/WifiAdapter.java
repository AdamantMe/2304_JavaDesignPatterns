package org.example.simulator.network;

import org.example.simulator.interfaces.NetworkInterface;

public class WifiAdapter extends NetworkInterface {
    public WifiAdapter(String name, String ipAddress, String mask) {
        super(name, ipAddress, mask);
    }

    @Override
    public void connect(String ipAddress) {
        // WiFi connection implementation
        System.out.println("Connecting via WiFi to " + ipAddress);
        this.connectedIp = ipAddress;
    }
}