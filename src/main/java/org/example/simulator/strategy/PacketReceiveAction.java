package org.example.simulator.strategy;

public class PacketReceiveAction implements EventActionStrategy {
    @Override
    public void executeAction(ActionEvent event) {

        System.out.println("Executing PacketReceiveAction: Packet received with data - " + event.getData());
    }
}
//TODO is this needed? referenced in end device but didnt exist so I made it