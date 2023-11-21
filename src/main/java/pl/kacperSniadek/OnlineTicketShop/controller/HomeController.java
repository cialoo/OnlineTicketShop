package pl.kacperSniadek.OnlineTicketShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kacperSniadek.OnlineTicketShop.model.Ticket;
import pl.kacperSniadek.OnlineTicketShop.repository.TicketRepository;

import java.util.List;

@Controller
public class HomeController {
    private final TicketRepository ticketRepository;

    @Autowired
    public HomeController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Ticket> tickets = ticketRepository.findAll();
        model.addAttribute("tickets", tickets);
        return "home";
    }

}
