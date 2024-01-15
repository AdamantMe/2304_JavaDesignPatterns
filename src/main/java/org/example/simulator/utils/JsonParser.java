package org.example.simulator.utils;

import org.example.simulator.factory.ConnectionFactory;
import org.example.simulator.factory.DeviceFactory;
import org.example.simulator.factory.EventFactory;
import org.example.simulator.network.Network;
import org.example.simulator.core.Event;
import org.example.simulator.network.device.Device;
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
        JSONArray connectionsJson = jsonObject.getJSONArray("connections");

        for (int i = 0; i < devicesJson.length(); i++) {
            JSONObject deviceJson = devicesJson.getJSONObject(i);
            String id = deviceJson.getString("id");
            String type = deviceJson.getString("type");

            //System.out.println("found device: " + type + " - " + id);
            //network.addDevice(deviceFactory.createDevice(type, id));
            Device device = deviceFactory.createDevice(type, id);
            network.addDevice(device);
            //System.out.println("Creating device: " + type + " - " + id);
            System.out.println("Device " + id + " created with MAC address: " + device.getMACAddress());

        }

        for (int i = 0; i < connectionsJson.length(); i++) {
            JSONObject connectionJson = connectionsJson.getJSONObject(i);
            String type = connectionJson.getString("type");
            String source = connectionJson.getString("source");
            String destination = connectionJson.getString("destination");
           // System.out.println("Creating Connection: " + type + " source " + source + " destination " + destination);

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
