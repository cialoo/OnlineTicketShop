package pl.kacperSniadek.OnlineTicketShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kacperSniadek.OnlineTicketShop.model.Ticket;
import pl.kacperSniadek.OnlineTicketShop.repository.TicketRepository;

import java.util.List;

@Controller
public class HomeController {
    private final TicketRepository ticketRepository;

    public HomeController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Ticket> tickets = ticketRepository.findAll();
        model.addAttribute("tickets", tickets);

        return "home";
    }
    @GetMapping("/order")
    public String order() {
        return "order";
    }
    @GetMapping("/orderComplete")
    public String orderComplete() {
        return "orderComplete";
    }
}
