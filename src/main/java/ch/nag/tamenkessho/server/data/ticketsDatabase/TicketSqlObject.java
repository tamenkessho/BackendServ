package ch.nag.tamenkessho.server.data.ticketsDatabase;

import ch.nag.tamenkessho.server.data.Ticket;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TicketSqlObject {
    @Id
    public int ID;
    public String date_time, description, groupe, title;
    public boolean status;

    public TicketSqlObject() {
    }

    public TicketSqlObject(Ticket ticket) {
        this.ID = ticket.ID;
        this.title = ticket.title;
        this.description = ticket.description;
        this.date_time = ticket.dateTime;
        this.status = ticket.status;
        this.groupe = ticket.group;
    }

    public TicketSqlObject(Integer ID, String title, String description, String date_time, boolean status, String groupe) {
        this.ID = ID;
        this.title = title;
        this.description = description;
        this.date_time = date_time;
        this.status = status;
        this.groupe = groupe;
        return;
    }

    public Integer getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String dateTime) {
        this.date_time = dateTime;
    }

    public boolean getStatus() {
        return status;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String group) {
        this.groupe = group;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + ID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + "'" +
                ", dateTime='" + date_time + "'" +
                ", group='" + groupe + "'" +
                '}';
    }
}