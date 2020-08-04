package com.example.idealperfume.Data;

public class EventData {
    private int eventimg;
    private String eventdate;

    public EventData(int eventimg, String eventdate) {
        this.eventimg = eventimg;
        this.eventdate = eventdate;
    }

    // getter
    public int getEventimg() {
        return eventimg;
    }

    public String getEventdate() {
        return eventdate;
    }

    // setter

    public void setEventimg(int eventimg) {
        this.eventimg = eventimg;
    }

    public void setEventdate(String eventdate) {
        this.eventdate = eventdate;
    }
}
