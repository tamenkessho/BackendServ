package ch.nag.tamenkessho.server;

import ch.nag.tamenkessho.server.data.Ticket;
import ch.nag.tamenkessho.server.data.TicketSqlObject;
import ch.nag.tamenkessho.server.data.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
public class TicketsRestController {
    String jsonString = "";
    @Autowired
    TicketsRepository repo;
    ArrayList<Ticket> ticketsList = new ArrayList<>();
    ArrayList<TicketSqlObject> sqlList = new ArrayList<>();

    @GetMapping("/nag/storage/tickets")
    private String ticketsRequest() {
        System.out.println("Request received");
        ticketsList.clear();
        for (TicketSqlObject object : repo.findAll()) {
            ticketsList.add(new Ticket(object));
        }
        jsonString = Ticket.getGson(ticketsList.toArray(new Ticket[0]));
        System.out.println(jsonString);
        return jsonString;
    }

    @PutMapping("/nag/storage/upload/tickets")
    private void setTickets(
            @RequestBody
            String jsonUpdatedTickets) {
        repo.deleteAll();
        var ticketArray = Ticket.getArray(jsonUpdatedTickets);
        sqlList.clear();
        for (Ticket ticket : ticketArray) {
            sqlList.add(new TicketSqlObject(ticket));
        }
        repo.saveAll(sqlList);
    }

    private Ticket[] tickets = new Ticket[0];
}