package org.example;

import org.w3c.dom.events.Event;

public abstract class Device {
    private String MAC;
    private String port;
    private String protocol;
    private String IP;
    private String MASK;
    private String Gateway;
    private RoutingTable routingTable;
    private Event event;
    //private NetworkAdapter networkAdapter;  // How to handle?

    public String getMAC() {
        return MAC;
    }
    public void setMAC(String newMAC) {
        MAC = newMAC;
    }

    public String getPort() {
        return port;
    }
    public void setPort(String newPort) {
        port = newPort;
    }

    public String getProtocol() {
        return protocol;
    }
    public void setProtocol(String newProtocol) {
        protocol = newProtocol;
    }

    public String getIP() {
        return IP;
    }
    public void setIP(String newIP) {
        IP = newIP;
    }

    public String getMASK() {
        return MASK;
    }
    public void setMASK(String newMASK) {
        MASK = newMASK;
    }

    public String getGateway() {
        return Gateway;
    }
    public void setGateway(String newGateway) {
        Gateway = newGateway;
    }

    public RoutingTable getRoutingTable() {
        return routingTable;
    }
    public void setRoutingTable(RoutingTable newRoutingTable) {
        routingTable = newRoutingTable;
    }

    public Event getEvent() {
        return event;
    }
    public void setEvent(Event newEvent) {
        event = newEvent;
    }

    // Add  get and set methods for networkAdapter

//    public void displayDeviceInfo() {
//    }

    public void sendData(Event event, Device nextDevice) {
        //Send data to the next device
        System.out.println("Data sent to next device");

    }

    public void receiveData(Device previousDevice) {
        //Receive data from the previous device
        System.out.println("Data Received by previous Device");

    }
}
