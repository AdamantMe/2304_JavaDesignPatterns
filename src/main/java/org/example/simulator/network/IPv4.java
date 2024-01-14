package org.example.simulator.network;

public class IPv4 extends NetworkProtocol {
    // Constructor that initializes IPv4 with default protocol name and type
    public IPv4(int ip, int mask, int gateway) {
        super("IPv4", "Stateful", ip, mask, gateway);
    }

    @Override
    public void configureProtocol() {
        
    }

    public void assignIP(int ip) {
        setIp(ip);
    }

    public void assignMask(int mask) {
        setMask(mask);
    }

    public void assignGateway(int gateway) {
        setGateway(gateway);
    }

}
