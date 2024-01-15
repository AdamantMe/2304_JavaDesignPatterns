package org.example.simulator.strategy;

public class PacketTransferAction implements EventActionStrategy {
    @Override
    public void executeAction(ActionEvent event) {
        // Logic to transfer the packet, simplified
        System.out.println("Packet transferred from " + event.getSource() + " to " + event.getDestination() + " with data: " + event.getData());
    }
}
