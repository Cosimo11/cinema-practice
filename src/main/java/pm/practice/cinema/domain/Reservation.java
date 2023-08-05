package pm.practice.cinema.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pm.practice.cinema.dto.incoming.ReservationCommand;
import pm.practice.cinema.service.ScreeningService;

@Entity
@Data
@NoArgsConstructor
@Table
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    private Integer numberOfSeats;
    @ManyToOne
    @JoinColumn(name = "screening_id")
    private Screening screening;

    public Reservation(ReservationCommand reservationCommand, Screening screening) {

        this.name= reservationCommand.getName();
        this.numberOfSeats= reservationCommand.getNumberOfSeats();
        this.screening = screening;
    }
}
