package org.example.simulator.network;

import org.example.simulator.interfaces.NetworkInterface;

public class EthernetAdapter extends NetworkInterface {
    public EthernetAdapter(String name, String ipAddress, String mask) {
        super(name, ipAddress, mask);
    }

    @Override
    public void connect(String ipAddress) {
        // Ethernet connection implementation
        System.out.println("Connecting via Ethernet to " + ipAddress);
        this.connectedIp = ipAddress;
    }
}