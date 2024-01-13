package org.example;

import org.w3c.dom.events.Event;

public abstract class Connection {
    private String type;
    private String speed;
    private String device1;
    private String device2;

    public String getType(){
        return type;
    }
    public void setType(String newType) {type = newType;
    }

    public String getSpeed(){
        return speed;
    }
    public void setSpeed(String newSpeed) {speed = newSpeed;
    }

    public String getDevice1(){
        return device1;
    }
    public void setDevice1(String newDevice1) {device1 = newDevice1;
    }

    public String getDevice2(){
        return device2;
    }
    public void setDevice2(String newDevice2) {device2 = newDevice2;
    }


    public void sendData(Event event) {
        //Send data to the next device
        System.out.println("Data sent to next device");

    }

    public void receiveData(Event event) {
        //Receive data from the previous device
        System.out.println("Data Received by previous Device");

    }


}
