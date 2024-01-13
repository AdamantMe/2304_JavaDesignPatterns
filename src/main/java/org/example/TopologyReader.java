package org.example;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TopologyReader {
    public List<Object> readObjects(String filePath, String objectType, DeviceFactory deviceFactory, ConnectionFactory connectionFactory) {
        try (JsonReader jsonReader = Json.createReader(new FileReader(filePath))) {
            JsonObject jsonObject = jsonReader.readObject();
            JsonObject objectsNode = jsonObject.getJsonObject(objectType);

            if (objectsNode != null) {
                List<Object> createdObjects = new ArrayList<>();

                for (String objectName : objectsNode.keySet()) {
                    String objectTypeForName = readObjectType(filePath, objectName);
                    if ("device".equals(objectTypeForName)) {
                        Device device = deviceFactory.createDevice(objectName);
                        createdObjects.add(device);
                    } else if ("connection".equals(objectTypeForName)) {
                        Connection connection = connectionFactory.createConnection(objectName);
                        createdObjects.add(connection);
                    }
                }

                return createdObjects;
            } else {
                return null; // or throw an exception if the type is not found
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String readObjectType(String filePath, String objectName) {
        try (JsonReader jsonReader = Json.createReader(new FileReader(filePath))) {
            JsonObject jsonObject = jsonReader.readObject();

            JsonObject devicesNode = jsonObject.getJsonObject("devices");
            JsonObject connectionsNode = jsonObject.getJsonObject("connections");

            if (devicesNode != null && devicesNode.containsKey(objectName)) {
                return "device";
            } else if (connectionsNode != null && connectionsNode.containsKey(objectName)) {
                return "connection";
            } else {
                return "unknown";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }

}