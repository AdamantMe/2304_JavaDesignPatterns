package org.example.simulator.factory;

import org.example.simulator.network.connection.Connection;
import org.example.simulator.network.connection.WiredConnection;
import org.example.simulator.network.connection.WirelessConnection;
import org.example.simulator.network.connection.ConnectionDecorator;
import org.example.simulator.network.connection.DataCorruptionDecorator;
import org.example.simulator.network.connection.DataLossDecorator;
import org.json.JSONArray;
import org.json.JSONObject;

public class ConnectionFactory {

    public Connection createConnection(JSONObject connectionJson) {
        String source = connectionJson.getString("source");
        String destination = connectionJson.getString("destination");
        String type = connectionJson.getString("type");

        Connection baseConnection = createBaseConnection(type, source, destination);

        if (connectionJson.has("decorators")) {
            JSONArray decoratorsJson = connectionJson.getJSONArray("decorators");
            for (int i = 0; i < decoratorsJson.length(); i++) {
                String decoratorType = decoratorsJson.getString(i);
                baseConnection = (Connection) addDecorator((ConnectionDecorator) baseConnection, decoratorType);
            }
        }

        return baseConnection;
    }

    private Connection createBaseConnection(String type, String source, String destination) {
        switch (type) {
            case "Wired":
                return new WiredConnection(source, destination);
            case "Wireless":
                return new WirelessConnection(source, destination);
            default:
                throw new IllegalArgumentException("Unknown connection type: " + type);
        }
    }

    private ConnectionDecorator addDecorator(ConnectionDecorator connectionDecorator, String decoratorType) {
        switch (decoratorType) {
            case "DataLoss":
                return new DataLossDecorator(connectionDecorator);
            case "DataCorruption":
                return new DataCorruptionDecorator(connectionDecorator);
            // Add more decorator types if needed
            default:
                throw new IllegalArgumentException("Unknown decorator type: " + decoratorType);
        }
    }



//        switch (type) {
//            case "Wired":
//                return new WiredConnection(source, destination);
//            case "Wireless":
//                return new WirelessConnection(source, destination);
//            default:
//                throw new IllegalArgumentException("Unknown connection type: " + type);
//        }
//    }
}
