package org.example.simulator.network;

public class MACaddGenerator {
    private static MACaddGenerator instance;
    private int currentMACAddress;

    private MACaddGenerator() {
        // Initialize the starting MAC address
        this.currentMACAddress = 1000; // what should it be?

    }

    public synchronized String generateMACAddress() {
        // Generate a unique MAC address
        String macAddress = "00:1A:2B:" + String.format("%04X", currentMACAddress);
        //System.out.println("Generated MAC address: " + macAddress); // Debugging statement
        currentMACAddress++;
        return macAddress;
    }
    public static synchronized MACaddGenerator getInstance() {
        if (instance == null) {
            instance = new MACaddGenerator();
        }
        return instance;
    }
}
