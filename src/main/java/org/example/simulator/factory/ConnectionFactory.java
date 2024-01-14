package org.example.simulator.factory;

import org.example.simulator.network.connection.Connection;
import org.example.simulator.network.connection.WiredConnection;
import org.example.simulator.network.connection.WirelessConnection;
import org.json.JSONObject;

public class ConnectionFactory {

    public Connection createConnection(JSONObject connectionJson) {
        String source = connectionJson.getString("source");
        String destination = connectionJson.getString("destination");
        String type = connectionJson.getString("type");

        switch (type) {
            case "Wired":
                return new WiredConnection(source, destination);
            case "Wireless":
                return new WirelessConnection(source, destination);
            default:
                throw new IllegalArgumentException("Unknown connection type: " + type);
        }
    }
}
