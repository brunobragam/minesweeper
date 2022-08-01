package com.brunobraga.minesweeper.component;

import lombok.Getter;

@Getter
public enum EventTypeEnum {
    CREATE(1), 
    DELETE(2), 
    UPDATE(3);

    private final int eventType;

    EventTypeEnum(int actionNumber) {
        eventType = actionNumber;
    }
    
    public static EventTypeEnum getEventType(int param){
        for (EventTypeEnum eventTypeEnum : EventTypeEnum.values()) {
            if (eventTypeEnum.getEventType() == param){
                return eventTypeEnum;
            }
        }
        return null;
    }
}

class TestClass {

    public static void main(String[] args) {

        System.out.println(EventTypeEnum.getEventType(1));
    }
}