package pl.kacperSniadek.OnlineTicketShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kacperSniadek.OnlineTicketShop.model.Order;
import pl.kacperSniadek.OnlineTicketShop.repository.OrderRepository;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/{ticketId}")
    public String order(@PathVariable Long ticketId, Model model) {
        model.addAttribute("ticketId", ticketId);
        return "order";
    }

    @PostMapping
    public String takeOrder(@RequestParam Long ticketId, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String phoneNumber) {
        Order order = new Order();
        order.setTicketId(ticketId);
        order.setFirstName(firstName);
        order.setLastName(lastName);
        order.setPhoneNumber(phoneNumber);
        orderRepository.save(order);

        return "orderComplete";
    }
}
