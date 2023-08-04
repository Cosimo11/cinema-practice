package pm.practice.cinema.dto.incoming;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data

public class ScreeningCommand {

    private String title;
    private LocalDateTime screeningDate;
    private Integer totalSeat;
    private String pictureUrl;



}
