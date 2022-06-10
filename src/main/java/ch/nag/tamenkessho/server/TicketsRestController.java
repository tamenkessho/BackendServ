package ch.nag.tamenkessho.server;

import ch.nag.tamenkessho.server.data.Ticket;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TicketsRestController {
    String jsonString = "";

    @GetMapping("/nag/storage/tickets")
    private String ticketsRequest() {
        System.out.println("Request received");

        jsonString = Ticket.getGson(tickets);
        System.out.println(jsonString);
        return jsonString;
    }


    private Ticket[] tickets = new Ticket[]{
            new Ticket(
                    "I require help with email",
                    "I really need help with my new email address right now. New NAG email doesnt work properly.",
                    true,
                    52,
                    "March 17, 2005"
            ),
            new Ticket(
                    "Require NgRx support",
                    "HEYYY SOUFIAN! GUESS WHAT? YESSS I AGAIN CANT DEAL WITH NGRX. Heeelp me, mate!",
                    false,
                    38,
                    "May 19, 2022"
            )};
}