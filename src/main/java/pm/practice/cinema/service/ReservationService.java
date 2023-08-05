package pm.practice.cinema.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pm.practice.cinema.controllers.ReservationController;
import pm.practice.cinema.domain.Reservation;
import pm.practice.cinema.domain.Screening;
import pm.practice.cinema.dto.incoming.ReservationCommand;
import pm.practice.cinema.dto.outgoing.ReservationListItem;
import pm.practice.cinema.repository.ReservationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReservationService {

    private final Logger logger = LoggerFactory.getLogger(ReservationService.class);

    private ReservationRepository reservationRepository;
    private ScreeningService screeningService;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, ScreeningService screeningService) {
        this.reservationRepository = reservationRepository;
        this.screeningService = screeningService;
    }

    public void addReservation(ReservationCommand reservationCommand) {
        Boolean flag = false;
        Screening screening = screeningService.updateScreeningWithReservation(reservationCommand.getScreeningId(), reservationCommand.getNumberOfSeats());
        if (screening != null) {
            reservationRepository.save(new Reservation(reservationCommand, screening));
            logger.info("Tickets reserved");
        }else logger.info("No available screening for this reservation");

    }

    public List<ReservationListItem> getAllReservations() {
        List<Reservation> reseravations = reservationRepository.findAll();
        List<ReservationListItem> reservationListItems= reseravations.stream().map(ReservationListItem::new).collect(Collectors.toList());
        logger.info("Reservations page requested");

        return reservationListItems;
    }
}
