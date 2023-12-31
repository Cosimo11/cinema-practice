package pm.practice.cinema.service;

import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pm.practice.cinema.domain.Reservation;
import pm.practice.cinema.domain.Screening;
import pm.practice.cinema.dto.incoming.ScreeningCommand;
import pm.practice.cinema.dto.outgoing.MovieSummaryItem;
import pm.practice.cinema.dto.outgoing.ScreeningListItem;
import pm.practice.cinema.dto.outgoing.ScreeningOptionItem;
import pm.practice.cinema.repository.ReservationRepository;
import pm.practice.cinema.repository.ScreeningRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class ScreeningService {
    private static final Logger logger = LoggerFactory.getLogger(ScreeningService.class);

    private ScreeningRepository screeningRepository;

    public ScreeningService(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    public void addScreening(ScreeningCommand screeningCommand) {
        screeningRepository.save(new Screening(screeningCommand));
        logger.info("New screening added");
    }

    public List<ScreeningListItem> getAllScreenings() {
        List<Screening> screenings = screeningRepository.findByOrderByScreeningDate();
        List<ScreeningListItem> screeningListItemList = screenings.stream().map(ScreeningListItem::new).collect(Collectors.toList());
        logger.info("Screenings page requested");

        return screeningListItemList;
    }



    public List<ScreeningOptionItem> getAllScreeningTitles() {
        List<Screening> screenings = screeningRepository.findAll();
        List<ScreeningOptionItem> screeningOptionItems = screenings.stream().map(ScreeningOptionItem::new).collect(Collectors.toList());
        return screeningOptionItems;
    }

    public Screening updateScreeningWithReservation(Long screeningId, Integer requiredSeats) {
        Screening screening = screeningRepository.findById(screeningId).orElseThrow(EntityNotFoundException::new);
        if (screening != null && screening.getFreeSeats() > requiredSeats) {
            screening.setFreeSeats(screening.getFreeSeats() - requiredSeats);
            return screening;
        } else logger.info("no such screening or not enough free seets for the reservation");
        return null;
    }

    public List<MovieSummaryItem> getAllSummaries() {
        List<MovieSummaryItem> summaries = new ArrayList<>();
        List<String> titles = screeningRepository.findAllDistinctTitles();
        for (String title : titles) {
            List<Screening> screenings = screeningRepository.findByTitle(title);

            int numberOfScreenings = screenings.size();
            int ticketsold = 0;

            for (Screening screening : screenings) {
                for (Reservation reservation : screening.getReservations()) {
                    ticketsold += reservation.getNumberOfSeats();
                }
            }
            summaries.add(new MovieSummaryItem(title, numberOfScreenings, ticketsold));


        }
        return summaries;
    }
}

