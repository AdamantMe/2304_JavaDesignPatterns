package org.example;

import java.util.HashMap;
import java.util.Map;

// CAMTable class for demonstration purposes
public class CAMtable {
    private Map<String, Integer> entries = new HashMap<>();

    public int searchMAC(String macAddress) {
        return entries.getOrDefault(macAddress, -1);
    }

    public void addEntry(String macAddress, int port) {
        entries.put(macAddress, port);
    }
}