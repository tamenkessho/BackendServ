package ch.nag.tamenkessho.server.data.ticketsDatabase;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsRepository extends CrudRepository<TicketSqlObject, Integer> {
}
