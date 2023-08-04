package pm.practice.cinema.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pm.practice.cinema.dto.incoming.ScreeningCommand;
import pm.practice.cinema.dto.outgoing.ScreeningListItem;
import pm.practice.cinema.service.ScreeningService;

import java.util.List;

@RestController
@RequestMapping("/api/screenings")
public class ScreeningController {

    private ScreeningService screeningService;

    public ScreeningController(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @PostMapping
    public ResponseEntity addScreening(@RequestBody ScreeningCommand command){
        screeningService.addScreening(command);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<ScreeningListItem>> getAllScreening() {
        return new ResponseEntity<>(screeningService.getAllScreenings(), HttpStatus.OK);

    }
}
