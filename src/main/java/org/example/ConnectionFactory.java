package org.example;

public class ConnectionFactory {
    public Connection createConnection(String type){
        Connection connection = null;

        if (type.equals("wired")){
            connection = new WiredConnection();
        } else if (type.equals("wireless")) {
            connection = new WirelessConnection();

        }

        return connection;
    }
}
