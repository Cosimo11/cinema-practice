package pm.practice.cinema.dto.outgoing;

import lombok.Data;
import pm.practice.cinema.domain.Screening;

@Data
public class ScreeningOptionItem {

    Long id;
    String title;


    public ScreeningOptionItem(Screening screening) {
        this.title = screening.getTitle();
        this.id = screening.getId();
    }
}
