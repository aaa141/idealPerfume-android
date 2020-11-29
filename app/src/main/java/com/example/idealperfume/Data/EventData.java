package com.example.idealperfume.Data;

public class EventData {
    private int eventimg;
    private String eventdate;
    private String eventtitle;
    private String eventslogan;

    public EventData(int eventimg, String eventdate, String eventtitle, String eventslogan) {
        this.eventimg = eventimg;
        this.eventdate = eventdate;
        this.eventtitle = eventtitle;
        this.eventslogan = eventslogan;
    }

    public int getEventimg() {
        return eventimg;
    }

    public void setEventimg(int eventimg) {
        this.eventimg = eventimg;
    }

    public String getEventdate() {
        return eventdate;
    }

    public void setEventdate(String eventdate) {
        this.eventdate = eventdate;
    }

    public String getEventtitle() {
        return eventtitle;
    }

    public void setEventtitle(String eventtitle) {
        this.eventtitle = eventtitle;
    }

    public String getEventslogan() {
        return eventslogan;
    }

    public void setEventslogan(String eventslogan) {
        this.eventslogan = eventslogan;
    }
}
