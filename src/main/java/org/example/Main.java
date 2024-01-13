package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String filePath = "src/Topology";
        String deviceType = "devices";
        String connectionType = "connections";

        // Create a DeviceFactory & connection factory
        DeviceFactory deviceFactory = new DeviceFactory();
        ConnectionFactory connectionFactory = new ConnectionFactory();


        // Create a DeviceBuilder and pass the DeviceFactory to it
        DeviceBuilder deviceBuilder = new DeviceBuilder();
        deviceBuilder.deviceBuilder(deviceFactory);

        // create connectionbuilder and pass the connection factory
        ConnectionBuilder connectionBuilder = new ConnectionBuilder();
        connectionBuilder.connectionBuilder(connectionFactory);

        // Read and create devices
        TopologyReader topologyReader = new TopologyReader();
        List<Object> devices = topologyReader.readObjects(filePath, deviceType, deviceFactory, connectionFactory);

        // Read and create connections
        List<Object> connections = topologyReader.readObjects(filePath, connectionType, deviceFactory, connectionFactory);

        // Print the list of devices
        System.out.println("Devices:");
        for (Object device : devices) {
            System.out.println(device);
        }

        // Print the list of connections
        System.out.println("Connections:");
        for (Object connection : connections) {
            System.out.println(connection);
        }
    }
}






//        // Create devices using the DeviceBuilder
//        Device endDevice = deviceBuilder.makeDevice("end");
//        Device switchDevice = deviceBuilder.makeDevice("switch");
//        Device routerDevice = deviceBuilder.makeDevice("router");
//
//
//        Connection wiredConnection = connectionBuilder.makeConnection("wired");
//        Connection wirelessConnection = connectionBuilder.makeConnection("wireless");
