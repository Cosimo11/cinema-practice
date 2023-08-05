package pm.practice.cinema.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pm.practice.cinema.dto.incoming.ScreeningCommand;
import pm.practice.cinema.repository.ScreeningRepository;


@Component
public class ScreeningCommandValidator implements Validator {

    private ScreeningRepository screeningRepository;

    @Autowired
    public ScreeningCommandValidator(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return ScreeningCommand.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ScreeningCommand screeningCommand = (ScreeningCommand) target;
        if (screeningCommand.getTotalSeat().intValue() > 155 || (screeningCommand.getTotalSeat().intValue() < 85)) {
            errors.rejectValue("totalSeat", "not.valid.totalseat");
        }

    }
}
