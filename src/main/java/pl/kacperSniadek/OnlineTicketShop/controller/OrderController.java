package pl.kacperSniadek.OnlineTicketShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kacperSniadek.OnlineTicketShop.model.Order;
import pl.kacperSniadek.OnlineTicketShop.model.Ticket;
import pl.kacperSniadek.OnlineTicketShop.repository.OrderRepository;
import pl.kacperSniadek.OnlineTicketShop.repository.TicketRepository;
import pl.kacperSniadek.OnlineTicketShop.service.TicketService;

@Controller
@RequestMapping("/order")
@SessionAttributes({"name", "firstName", "lastName", "location"})
public class OrderController {

    private final OrderRepository orderRepository;
    private final TicketService ticketService;

    public OrderController(OrderRepository orderRepository, TicketService ticketService) {
        this.orderRepository = orderRepository;
        this.ticketService = ticketService;
    }

    @GetMapping("/{ticketId}/{name}/{location}")
    public String order(@PathVariable Long ticketId, @PathVariable String name, @PathVariable String location, Model model) {
        model.addAttribute("ticketId", ticketId);
        model.addAttribute("name", name);
        model.addAttribute("location", location);
        return "order";
    }

    @PostMapping
    public String takeOrder(Model model,
                            @RequestParam Long ticketId,
                            @RequestParam String name,
                            @RequestParam String location,
                            @RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam String phoneNumber) {
        Order order = new Order();
        order.setTicketId(ticketId);
        order.setFirstName(firstName);
        order.setLastName(lastName);
        order.setPhoneNumber(phoneNumber);
        orderRepository.save(order);

        ticketService.decreaseSeats(ticketId);

        model.addAttribute("name", name);
        model.addAttribute("location", location);
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);

        return "redirect:/orderComplete";
    }
}
