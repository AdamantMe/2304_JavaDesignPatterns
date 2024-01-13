package org.example;

import java.util.HashMap;
import java.util.Map;

public class RoutingTable {
    private Map<String, String> entries = new HashMap<>();

    public String searchIP(String ipAddress) {
        return entries.get(ipAddress);
    }

    public void addEntry(String ipAddress, String mask) {
        entries.put(ipAddress, mask);
    }

    // Method to get the IP address from the routing table
    public String routerIpAddressMethod() {
        // Implement logic to get the IP address
        return searchIP("routerIPKey");
    }

    // Getter method to retrieve the value associated with the given IP address
    public String get(String ipAddress) {
        return entries.get(ipAddress);
    }

    // Check if the routing table contains the given IP address
    public boolean containsKey(String ipAddress) {
        return entries.containsKey(ipAddress);
    }
}
