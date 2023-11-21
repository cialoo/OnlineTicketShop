package pl.kacperSniadek.OnlineTicketShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kacperSniadek.OnlineTicketShop.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
