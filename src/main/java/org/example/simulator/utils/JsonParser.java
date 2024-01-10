package org.example.simulator.utils;

import org.example.simulator.network.DeviceFactory;
import org.example.simulator.network.Network;
import org.example.simulator.core.Event;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JsonParser {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public static Network parseNetwork(JSONObject jsonObject, DeviceFactory deviceFactory) {
        Network network = new Network();
        JSONArray devicesJson = jsonObject.getJSONArray("devices");

        for (int i = 0; i < devicesJson.length(); i++) {
            JSONObject deviceJson = devicesJson.getJSONObject(i);
            String id = deviceJson.getString("id");
            String type = deviceJson.getString("type");
            network.addDevice(deviceFactory.createDevice(type, id));
        }

        // Parse connections and add them to the network
        JSONArray connectionsJson = jsonObject.getJSONArray("connections");
        for (int i = 0; i < connectionsJson.length(); i++) {
            JSONObject connectionJson = connectionsJson.getJSONObject(i);
            String source = connectionJson.getString("source");
            String destination = connectionJson.getString("destination");
            network.addConnection(source, destination);
        }

        return network;
    }

    public static List<Event> parseEvents(JSONArray eventsJson) {
        List<Event> events = new ArrayList<>();

        for (int i = 0; i < eventsJson.length(); i++) {
            JSONObject eventJson = eventsJson.getJSONObject(i);
            Event event = new Event(
                    eventJson.getString("id"),
                    Event.EventType.valueOf(eventJson.getString("eventType")),
                    LocalDateTime.parse(eventJson.getString("startTime"), formatter),
                    Optional.ofNullable(eventJson.optString("source", null)),
                    Optional.ofNullable(eventJson.optString("destination", null)),
                    Optional.ofNullable(eventJson.optString("data", null)),
                    Optional.ofNullable(eventJson.optString("status", null)),
                    Optional.ofNullable(eventJson.optString("device", null))
            );
            events.add(event);
        }
        return events;
    }
}