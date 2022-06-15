package ch.nag.tamenkessho.server.data;

import ch.nag.tamenkessho.server.data.ticketsDatabase.TicketSqlObject;
import com.google.gson.Gson;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Ticket {

    static public String getGson(Ticket[] tickets) {
        return new Gson().toJson(tickets);
    }

    static public Ticket[] getArray(String jsonRealization) {
        return new Gson().fromJson(jsonRealization, Ticket[].class);
    }
    @Id
    @GeneratedValue
    public int ID;
    public final String title;
    public final String description;
    public final boolean status;
    public final String dateTime;
    public final String group;



    public Ticket(TicketSqlObject ticket){
        this.ID = ticket.getID();
        this.title = ticket.getTitle();
        this.description = ticket.getDescription();
        this.dateTime = ticket.getDate_time();
        this.status = ticket.getStatus();
        this.group = ticket.getGroupe();
    }
    public Ticket(String title, String description, boolean status, int ID, String date, String group) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.dateTime = date;
        this.ID = ID;
        this.group = group;
    }
}
