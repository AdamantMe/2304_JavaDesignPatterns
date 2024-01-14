package org.example.simulator.utils;

import org.example.simulator.factory.ConnectionFactory;
import org.example.simulator.factory.DeviceFactory;
import org.example.simulator.factory.EventFactory;
import org.example.simulator.network.Network;
import org.example.simulator.core.Event;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public static Network parseNetwork(JSONObject jsonObject, DeviceFactory deviceFactory, ConnectionFactory connectionFactory) {
        Network network = new Network();
        JSONArray devicesJson = jsonObject.getJSONArray("devices");

        for (int i = 0; i < devicesJson.length(); i++) {
            JSONObject deviceJson = devicesJson.getJSONObject(i);
            String id = deviceJson.getString("id");
            String type = deviceJson.getString("type");
            network.addDevice(deviceFactory.createDevice(type, id));
        }

        JSONArray connectionsJson = jsonObject.getJSONArray("connections");
        for (int i = 0; i < connectionsJson.length(); i++) {
            JSONObject connectionJson = connectionsJson.getJSONObject(i);
            network.addConnection(connectionFactory.createConnection(connectionJson));
        }

        return network;
    }

    public static List<Event> parseEvents(JSONArray eventsJson, EventFactory eventFactory) {
        List<Event> events = new ArrayList<>();

        for (int i = 0; i < eventsJson.length(); i++) {
            JSONObject eventJson = eventsJson.getJSONObject(i);
            events.add(eventFactory.createEvent(eventJson));
        }

        return events;
    }
}
