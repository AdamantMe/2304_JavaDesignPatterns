package org.example.simulator.network;

import org.example.simulator.interfaces.NetworkInterface;

public class RoutingTableRecord {
    private String networkDestination;
    private String netmask;
    private String gateway;
    private NetworkInterface port; 

    // Constructor to initialize the RoutingTableRecord
    public RoutingTableRecord(String networkDestination, String netmask, String gateway, NetworkInterface port) {
        this.networkDestination = networkDestination;
        this.netmask = netmask;
        this.gateway = gateway;
        this.port = port;
    }

    // Attributes
    public String getNetworkDestination() {
        return networkDestination;
    }

    public void setNetworkDestination(String networkDestination) {
        this.networkDestination = networkDestination;
    }

    public String getNetmask() {
        return netmask;
    }

    public void setNetmask(String netmask) {
        this.netmask = netmask;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public NetworkInterface getPort() {
        return port;
    }

    public void setPort(NetworkInterface port) {
        this.port = port;
    }
}
