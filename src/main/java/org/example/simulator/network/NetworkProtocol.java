package org.example.simulator.network;

public abstract class NetworkProtocol {
    protected String name;
    protected String type;
    protected RoutingTable routingTable;

    public NetworkProtocol(String name, String type) {
        this.name = name;
        this.type = type;
        this.routingTable = new RoutingTable();
    }

    // Abstract methods to be implemented by subclasses (IPv4 and IPv6)
    public abstract void configureProtocol();

}
