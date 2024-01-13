package org.example.simulator.interfaces;

public abstract class NetworkInterface {
    protected String name;
    protected String ipAddress;
    protected String mask;
    protected String connectedIp;

    public NetworkInterface(String name, String ipAddress, String mask) {
        this.name = name;
        this.ipAddress = ipAddress;
        this.mask = mask;
    }

    // Attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getConnectedIp() {
        return connectedIp;
    }

    public void setConnectedIp(String connectedIp) {
        this.connectedIp = connectedIp;
    }

    // Abstract method to be implemented by subclasses
    public abstract void connect(String ipAddress);
}