package org.example;

public class ConnectionBuilder {
    ConnectionFactory factory;

    public void connectionBuilder(ConnectionFactory factory) {
        this.factory = factory;
    }

    public Connection makeConnection(String type){
        Connection connection;
        connection = factory.createConnection(type);

        return connection;
    }
}
