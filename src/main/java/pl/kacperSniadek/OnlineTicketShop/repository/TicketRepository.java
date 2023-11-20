package pl.kacperSniadek.OnlineTicketShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kacperSniadek.OnlineTicketShop.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
