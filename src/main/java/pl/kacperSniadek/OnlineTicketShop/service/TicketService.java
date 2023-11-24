package pl.kacperSniadek.OnlineTicketShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kacperSniadek.OnlineTicketShop.model.Ticket;
import pl.kacperSniadek.OnlineTicketShop.repository.TicketRepository;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void decreaseSeats(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new IllegalArgumentException("Ticket not found"));

        if (ticket.getNumberOfSeats() > 0) {
            ticket.setNumberOfSeats(ticket.getNumberOfSeats() - 1);
            ticketRepository.save(ticket);
        } else {
            throw new IllegalStateException("No available seats for this ticket");
        }
    }
}
