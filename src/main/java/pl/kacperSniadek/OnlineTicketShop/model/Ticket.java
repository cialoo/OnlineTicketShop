package pl.kacperSniadek.OnlineTicketShop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Setter
@Getter
public class Ticket {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String posterUrl;
    private LocalDateTime date;
    private BigDecimal price;
}
