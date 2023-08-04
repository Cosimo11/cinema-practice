package pm.practice.cinema.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    private Integer numberOfSeats;

}
