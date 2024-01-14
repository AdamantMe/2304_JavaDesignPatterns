package org.example.simulator.strategy;

public class DeviceFailureAction implements EventActionStrategy {
    @Override
    public void executeAction(ActionEvent event) {
        // Logic to handle a device failure, simplified
//        System.out.println("Device failure event for device " + event.getDevice().orElse("Unknown"));
    }
}