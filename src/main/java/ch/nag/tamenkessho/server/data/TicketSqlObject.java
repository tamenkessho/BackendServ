package ch.nag.tamenkessho.server.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TicketSqlObject {
    @Id
    public int ID;
    public String title, description, date_time;
    public boolean status;

    public TicketSqlObject() {
    }

    public TicketSqlObject(Ticket ticket) {
        this.ID = ticket.ID;
        this.title = ticket.title;
        this.description = ticket.description;
        this.date_time = ticket.dateTime;
        this.status = ticket.status;
    }

    public TicketSqlObject(Integer ID, String title, String description, String date_time, boolean status) {
        this.ID = ID;
        this.title = title;
        this.description = description;
        this.date_time = date_time;
        this.status = status;
        return;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + ID +
                ", title='" + title + '\'' +
        ", description='" + description + '\'' +
                ", status='"+status+"'" +
                ", dateTime='"+date_time+"'"+
        '}';
    }
}