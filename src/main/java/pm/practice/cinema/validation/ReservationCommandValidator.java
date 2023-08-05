package pm.practice.cinema.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pm.practice.cinema.domain.Screening;
import pm.practice.cinema.dto.incoming.ReservationCommand;
import pm.practice.cinema.repository.ReservationRepository;
import pm.practice.cinema.repository.ScreeningRepository;
import pm.practice.cinema.service.ScreeningService;

import java.util.Optional;

@Component
public class ReservationCommandValidator implements Validator {

    private ReservationRepository reservationRepository;
    private ScreeningRepository screeningRepository;
    private ScreeningService screeningService;

    public ReservationCommandValidator(ReservationRepository reservationRepository, ScreeningRepository screeningRepository, ScreeningService screeningService) {
        this.reservationRepository = reservationRepository;
        this.screeningRepository = screeningRepository;

        this.screeningService = screeningService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return ReservationCommand.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ReservationCommand reservationCommand = (ReservationCommand) target;
        Optional<Screening> screeningOptional = screeningRepository.findById(reservationCommand.getScreeningId());
        if (screeningOptional.isEmpty()) {
            errors.rejectValue("screeningId", "screening.does.not.exist");
        } else {
            Screening screening = screeningOptional.get();

            if (reservationCommand.getNumberOfSeats() > screening.getFreeSeats()) {
                errors.rejectValue("numberOfSeats", "not.enough.seats");
            }

        }
    }
}
