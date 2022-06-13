package ch.nag.tamenkessho.server.data;

import ch.nag.tamenkessho.server.data.ticketsDatabase.TicketSqlObject;
import com.google.gson.Gson;

public class Ticket {

    static public String getGson(Ticket[] tickets) {
        return new Gson().toJson(tickets);
    }

    static public Ticket[] getArray(String jsonRealization) {
        return new Gson().fromJson(jsonRealization, Ticket[].class);
    }

    public String title, description, dateTime;
    public boolean status;
    public int ID;

    public Ticket(TicketSqlObject ticket){
        this.ID = ticket.getID();
        this.title = ticket.getTitle();
        this.description = ticket.getDescription();
        this.dateTime = ticket.getDate_time();
        this.status = ticket.getStatus();
    }
    public Ticket(String title, String description, boolean status, int ID, String date) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.dateTime = date;
        this.ID = ID;
    }
}
