package org.example.simulator.network;

public abstract class NetworkProtocol {
    protected String name;
    protected String type;
    protected int ip; 
    protected int mask;
    protected int gateway;
    protected RoutingTable routingTable;

    public NetworkProtocol(String name, String type, int ip, int mask, int gateway) {
        this.name = name;
        this.type = type;
        this.ip = ip;
        this.mask = mask;
        this.gateway = gateway;
        this.routingTable = new RoutingTable();
    }

    // Abstract methods to be implemented by subclasses ( IPv4 and IPv6 )
    public abstract void configureProtocol();

    // Getters and setters
    public int getIp() {
        return ip;
    }

    public void setIp(int ip) {
        this.ip = ip;
    }

    public int getMask() {
        return mask;
    }

    public void setMask(int mask) {
        this.mask = mask;
    }

    public int getGateway() {
        return gateway;
    }

    public void setGateway(int gateway) {
        this.gateway = gateway;
    }

}
