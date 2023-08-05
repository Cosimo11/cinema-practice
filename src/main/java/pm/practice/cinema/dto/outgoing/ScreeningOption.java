package pm.practice.cinema.dto.outgoing;

import lombok.Data;
import pm.practice.cinema.domain.Screening;

import java.util.List;

@Data
public class ScreeningOption {
    List<Screening> availScreenings;
}
