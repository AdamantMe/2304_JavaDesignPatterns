package org.example.simulator.factory;

import org.example.simulator.core.Event;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class EventFactory {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public Event createEvent(JSONObject eventJson) {
        String id = eventJson.getString("id");
        Event.EventType eventType = Event.EventType.valueOf(eventJson.getString("eventType"));
        LocalDateTime startTime = LocalDateTime.parse(eventJson.getString("startTime"), formatter);
        Optional<String> source = Optional.ofNullable(eventJson.optString("source", null));
        Optional<String> destination = Optional.ofNullable(eventJson.optString("destination", null));
        Optional<String> data = Optional.ofNullable(eventJson.optString("data", null));
        Optional<String> status = Optional.ofNullable(eventJson.optString("status", null));
        Optional<String> device = Optional.ofNullable(eventJson.optString("device", null));

        return new Event(id, eventType, startTime, source, destination, data, status, device);
    }
}
