package pm.practice.cinema.controllers;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pm.practice.cinema.dto.incoming.ScreeningCommand;
import pm.practice.cinema.dto.outgoing.ScreeningListItem;
import pm.practice.cinema.dto.outgoing.ScreeningOptionItem;
import pm.practice.cinema.service.ScreeningService;
import pm.practice.cinema.validation.ScreeningCommandValidator;

import java.util.List;

@RestController
@RequestMapping("/api/screenings")
public class ScreeningController {
    private static final Logger logger = LoggerFactory.getLogger(ScreeningController.class);
    private ScreeningService screeningService;
    private ScreeningCommandValidator screeningCommandValidator;

    @Autowired
    public ScreeningController(ScreeningService screeningService, ScreeningCommandValidator screeningCommandValidator) {
        this.screeningService = screeningService;
        this.screeningCommandValidator = screeningCommandValidator;
    }

    @InitBinder("screeningCommand")
    public void initBinderScreeningCommand(WebDataBinder binder) {
        binder.addValidators(screeningCommandValidator);
    }

    @PostMapping
    public ResponseEntity addScreening(@RequestBody @Valid ScreeningCommand screeningCommand) {
        screeningService.addScreening(screeningCommand);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<ScreeningListItem>> getAllScreening() {
        return new ResponseEntity<>(screeningService.getAllScreenings(), HttpStatus.OK);

    }

    @GetMapping(("/screeningOption"))
    public ResponseEntity<List<ScreeningOptionItem>> getAllScreeningTitles() {
        return new ResponseEntity<>(screeningService.getAllScreeningTitles(), HttpStatus.OK);

    }

}
