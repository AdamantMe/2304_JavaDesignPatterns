// Connection.java
package org.example.simulator.network;

public class Connection {
    private String source;
    private String destination;
    private String type;

    public Connection(String source, String destination, String type) {
        this.source = source;
        this.destination = destination;
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getType() {
        return type;
    }
}
