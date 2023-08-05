package pm.practice.cinema.dto.incoming;

import lombok.Data;
import pm.practice.cinema.domain.Screening;

@Data
public class ReservationCommand {

    private String name;
    private Integer numberOfSeats;
    private Long screeningId;


}
