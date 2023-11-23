package pl.kacperSniadek.OnlineTicketShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kacperSniadek.OnlineTicketShop.model.Order;
import pl.kacperSniadek.OnlineTicketShop.repository.OrderRepository;

@Controller
@RequestMapping("/order")
@SessionAttributes({"name", "firstName", "lastName"})
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/{ticketId}/{name}")
    public String order(@PathVariable Long ticketId, @PathVariable String name, Model model) {
        model.addAttribute("ticketId", ticketId);
        model.addAttribute("name", name);
        return "order";
    }

    @PostMapping
    public String takeOrder(Model model, @RequestParam Long ticketId, @RequestParam String name, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String phoneNumber) {
        Order order = new Order();
        order.setTicketId(ticketId);
        order.setFirstName(firstName);
        order.setLastName(lastName);
        order.setPhoneNumber(phoneNumber);
        orderRepository.save(order);

        model.addAttribute("name", name);
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);

        return "redirect:/orderComplete";
    }
}
