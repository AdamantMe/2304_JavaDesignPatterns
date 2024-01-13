package org.example.simulator.interfaces;

public class WifiInterface extends NetworkInterface {
    public WifiInterface(String name, String ipAddress, String mask) {
        super(name, ipAddress, mask);
    }

    @Override
    public void connect(String ipAddress) {
        // WiFi connection implementation
        System.out.println("Connecting via WiFi to " + ipAddress);
        this.connectedIp = ipAddress;
    }
}