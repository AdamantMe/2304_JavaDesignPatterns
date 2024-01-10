package org.example.simulator.core;

import java.time.LocalDateTime;
import java.util.Optional;

public class Event implements Comparable<Event> {
    private final String id;
    private final EventType eventType;
    private final LocalDateTime startTime;
    private final Optional<String> source;
    private final Optional<String> destination;
    private final Optional<String> data;
    private final Optional<String> status; // For DEVICE_FAILURE
    private final Optional<String> device; // For DEVICE_FAILURE

    public Event(
            String id,
            EventType eventType,
            LocalDateTime startTime,
            Optional<String> source,
            Optional<String> destination,
            Optional<String> data,
            Optional<String> status,
            Optional<String> device
    ) {
        this.id = id;
        this.eventType = eventType;
        this.startTime = startTime;
        this.source = source;
        this.destination = destination;
        this.data = data;
        this.status = status;
        this.device = device;
    }

    public String getId() {
        return id;
    }

    public EventType getEventType() {
        return eventType;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Optional<String> getSource() {
        return source;
    }

    public Optional<String> getDestination() {
        return destination;
    }

    public Optional<String> getData() {
        return data;
    }

    public Optional<String> getStatus() {
        return status;
    }

    public Optional<String> getDevice() {
        return device;
    }

    @Override
    public int compareTo(Event other) {
        return this.startTime.compareTo(other.startTime);
    }

    public enum EventType {
        PACKET_TRANSFER,
        DEVICE_FAILURE,
    }
}