package pl.kacperSniadek.OnlineTicketShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kacperSniadek.OnlineTicketShop.model.Ticket;
import pl.kacperSniadek.OnlineTicketShop.repository.TicketRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final TicketRepository ticketRepository;
    @Autowired
    public AdminController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping
    private String admin() {
        return "addTicket";
    }
    @PostMapping
    private String addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
        return "redirect:/admin";
    }
}
