package org.example.simulator.factory;

import org.example.simulator.network.Connection;
import org.json.JSONObject;

public class ConnectionFactory {

    public Connection createConnection(JSONObject connectionJson) {
        String source = connectionJson.getString("source");
        String destination = connectionJson.getString("destination");
        String type = connectionJson.getString("type");

        return new Connection(source, destination, type);
    }
}
