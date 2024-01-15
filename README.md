# Network Simulation

This network simulation project simulates the behavior of devices in a computer network. It is designed to demonstrate how events like packet transfers and device failures are processed within the network.

## Components

### Event
- Represents an event within the network.
- Each event has an ID, event type, start time, and optional attributes like source, destination, data etc.
- Event types include PACKET_TRANSFER and DEVICE_FAILURE.

### SimulationController
- Manages the simulation and processes events.
- Uses a priority queue to schedule and execute events in chronological order.
- Handles data loss and calculates the total data loss count.
- Processes different event types like PACKET_TRANSFER and DEVICE_FAILURE.

### JsonParser
- Parses a JSON configuration file to create network devices and events.
- Converts the JSON data into Java objects for the simulation.

### Network
- Represents the computer network.
- Stores devices and their connections.
- Processes PACKET_TRANSFER events by forwarding packets between devices.
- Processes DEVICE_FAILURE events (to be implemented).

### Main
- The entry point of the simulation.
- Reads the simulation configuration from a JSON file.
- Initializes the network, devices, and events.
- Starts the simulation by invoking the SimulationController.

### Design Patterns Implementation
- Applied Singleton pattern to the Network class for centralized network management.
- Utilized Factory/Abstract Factory patterns for creating network devices, connections, and events dynamically.
- Strategy pattern implemented in event handling to allow different behaviors for packet transfers and receptions.
- Command pattern used in the SimulationController to encapsulate event processing.
- Decorator pattern introduced in connection classes to simulate data corruption and loss dynamically.

## How to Run

1. Create a JSON configuration file with your desired network setup and events.

2. Update the `jsonFilePath` variable in the `Main` class to point to your JSON file.

3. Compile and run the `Main` class.

## Example JSON Configuration

```json
{
  "events": [
    {
      "id": "1",
      "eventType": "PACKET_TRANSFER",
      "startTime": "2024-01-10T10:00:00",
      "source": "DeviceA",
      "destination": "DeviceB",
      "data": "Hello, World!"
    },
    {
      "id": "2",
      "eventType": "DEVICE_FAILURE",
      "startTime": "2024-01-10T10:10:00",
      "device": "RouterC",
      "status": "FAILED"
    }
  ],
  "devices": [
    {
      "id": "DeviceA",
      "type": "EndDevice"
    },
    {
      "id": "DeviceB",
      "type": "EndDevice"
    },
    {
      "id": "RouterA",
      "type": "Router"
    }
  ],
  "connections": [
    {
      "source": "DeviceA",
      "destination": "DeviceB",
      "type": "Ethernet"
    }
  ]
}
