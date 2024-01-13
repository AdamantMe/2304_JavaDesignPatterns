package org.example.simulator.interfaces;

public class EthernetInterface extends NetworkInterface {
    public EthernetInterface(String name, String ipAddress, String mask) {
        super(name, ipAddress, mask);
    }

    @Override
    public void connect(String ipAddress) {
        // Ethernet connection implementation
        System.out.println("Connecting via Ethernet to " + ipAddress);
        this.connectedIp = ipAddress;
    }
}