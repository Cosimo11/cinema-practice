package pm.practice.cinema.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pm.practice.cinema.domain.Screening;
import pm.practice.cinema.dto.incoming.ScreeningCommand;
import pm.practice.cinema.dto.outgoing.ScreeningListItem;
import pm.practice.cinema.repository.ScreeningRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ScreeningService {

    private ScreeningRepository screeningRepository;

    public ScreeningService(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    public void addScreening(ScreeningCommand screeningCommand) {
        screeningRepository.save(new Screening(screeningCommand));
    }

    public List<ScreeningListItem> getAllScreenings() {
        List<Screening> screenings = screeningRepository.findByOrderByScreeningDate();
        List<ScreeningListItem> screeningListItemList = screenings.stream().map(ScreeningListItem::new).collect(Collectors.toList());
        return  screeningListItemList;
    }
}
