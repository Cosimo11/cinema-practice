package pm.practice.cinema.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pm.practice.cinema.dto.incoming.ScreeningCommand;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private LocalDateTime screeningDate;

    @Column
    private Integer totalSeat;

    @Column
    private String pictureUrl;

    @Column
    private Integer freeSeats;

    @OneToMany(mappedBy = "screening")
    private List<Reservation> reservations = new ArrayList<>();



    public Screening(ScreeningCommand screeningCommand) {
        this.title = screeningCommand.getTitle();
        this.screeningDate = screeningCommand.getScreeningDate();
        this.totalSeat = screeningCommand.getTotalSeat();
        this.pictureUrl = screeningCommand.getPictureUrl();
        this.freeSeats = this.totalSeat;
    }
}
