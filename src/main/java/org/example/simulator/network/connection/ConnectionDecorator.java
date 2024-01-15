package org.example.simulator.network.connection;


public interface ConnectionDecorator extends BaseConnection {
    int getDataLossCount();
    boolean getResult();
}