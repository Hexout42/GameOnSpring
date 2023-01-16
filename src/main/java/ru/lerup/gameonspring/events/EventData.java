package ru.lerup.gameonspring.events;


import lombok.Data;

@Data
public class EventData  {
    private  String text;

    public EventData(String text) {
        this.text = text;

    }
}
