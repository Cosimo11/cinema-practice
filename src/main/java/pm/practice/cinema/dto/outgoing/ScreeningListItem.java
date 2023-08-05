package pm.practice.cinema.dto.outgoing;


import lombok.Data;
import lombok.NoArgsConstructor;
import pm.practice.cinema.domain.Screening;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class ScreeningListItem {

    private String pictureUrl;
    private String title;
    private String screeningDate;
    private Integer totalSeat;
    private Integer freeSeats;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");

    public ScreeningListItem(Screening screening) {
        this.pictureUrl = screening.getPictureUrl();
        this.title = screening.getTitle();
        this.screeningDate = screening.getScreeningDate().format(formatter);
        this.totalSeat = screening.getTotalSeat();
        this.freeSeats = screening.getFreeSeats();
    }


}
