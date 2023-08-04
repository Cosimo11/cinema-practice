package pm.practice.cinema.dto.outgoing;


import lombok.Data;
import lombok.NoArgsConstructor;
import pm.practice.cinema.domain.Screening;

import java.sql.Time;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class ScreeningListItem {

    private String pictureUrl;
    private String title;
    private LocalDateTime screeningDate;
    private Integer totalSeat;
    private Integer freeSeats;

    public ScreeningListItem(Screening screening) {
        this.pictureUrl = screening.getPictureUrl();
        this.title = screening.getTitle();
        this.screeningDate = screening.getScreeningDate();
        this.totalSeat = screening.getTotalSeat();
        this.freeSeats = this.totalSeat;
    }
}
