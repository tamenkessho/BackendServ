package ch.nag.tamenkessho.server.restcontrollers;

import ch.nag.tamenkessho.server.data.Ticket;
import ch.nag.tamenkessho.server.data.ticketsDatabase.TicketSqlObject;
import ch.nag.tamenkessho.server.data.ticketsDatabase.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
public class TicketsRestController {
    String jsonString = "";
    final
    TicketsRepository repo;
    final ArrayList<Ticket> ticketsList = new ArrayList<>();
    final ArrayList<TicketSqlObject> sqlList = new ArrayList<>();

    public TicketsRestController(TicketsRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/nag/storage/tickets")
    private String ticketsRequest() {

        ticketsList.clear();
        for (TicketSqlObject object : repo.findAll())
            ticketsList.add(new Ticket(object));

        jsonString = Ticket.getGson(ticketsList.toArray(new Ticket[0]));
        System.out.println(jsonString);
        return jsonString;
    }

    @PutMapping("/nag/storage/upload/tickets")
    private void setTickets(
            @RequestBody
            String jsonUpdatedTickets) {
        var ticketArray = Ticket.getArray(jsonUpdatedTickets);
        sqlList.clear();

        for (Ticket ticket : ticketArray)
            sqlList.add(new TicketSqlObject(ticket));

        repo.deleteAll();
        repo.saveAll(sqlList);
    }
}