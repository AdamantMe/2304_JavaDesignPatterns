package org.example.simulator.strategy;

import java.time.LocalDateTime;

public class ActionEvent {
    private String source;
    private String destination;
    private String data;
    private LocalDateTime timestamp;
    private EventActionStrategy actionStrategy;

    public ActionEvent(EventActionStrategy actionStrategy) {
        this.actionStrategy = actionStrategy;
        this.timestamp = LocalDateTime.now();
    }

    public void execute() {
        if (actionStrategy != null) {
            actionStrategy.executeAction(this);
        } else {
            System.out.println(timestamp + ": Packet received with data: " + data);
        }
    }

    public void setSource(String source) { this.source = source; }
    public void setDestination(String destination) { this.destination = destination; }
    public void setData(String data) { this.data = data; }

    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public String getData() { return data; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
