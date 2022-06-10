package ch.nag.tamenkessho.server.data;

import com.google.gson.Gson;

public class Ticket {

    static public String getGson(Ticket[] tickets) {
        System.out.println(tickets[0].toString());
        return new Gson().toJson(tickets);
    }

    private String title;
    private String description;
    private boolean status;
    private int ID;
    private String dateTime;


    public Ticket(String title, String description, boolean status, int ID, String date) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.dateTime = date;
        this.ID = ID;
    }
}
