package org.example.simulator.network;

import java.util.HashMap;
import java.util.Map;

public class CAMtable {
    private Map<String, String> entries;

    public CAMtable() {
        this.entries = new HashMap<>();
    }

    public void addToTable(String macAddress, String port) {
        entries.put(macAddress, port);
    }

    public String getPort(String macAddress) {
        return entries.get(macAddress);
    }

    public void removeFromTable(String macAddress) {
        entries.remove(macAddress);
    }

    public void clearTable() {
        entries.clear();
    }
}