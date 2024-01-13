package org.example.simulator.network;

import org.example.simulator.interfaces.NetworkInterface;

import java.util.ArrayList;
import java.util.List;

public class RoutingTable {
    private List<RoutingTableRecord> records;

    public RoutingTable() {
        this.records = new ArrayList<>();
    }

    public void addRecord(RoutingTableRecord record) {
        records.add(record);
    }

    // Method to lookup network interface based on IP address
    public NetworkInterface lookup(String ipAddr) {
        for (RoutingTableRecord record : records) {
            if (record.getNetworkDestination().equals(ipAddr)) {
                return record.getPort();
            }
        }
        return null; 
    }

}