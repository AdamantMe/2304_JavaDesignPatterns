package org.example.simulator.network;

public class IPv6 extends NetworkProtocol {
    // Constructor that initializes IPv6 with default protocol name and type
    public IPv6(int ip, int mask, int gateway) {
        super("IPv6", "Stateless", ip, mask, gateway);
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
