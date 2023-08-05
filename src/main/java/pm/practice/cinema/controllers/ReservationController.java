package pm.practice.cinema.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pm.practice.cinema.dto.incoming.ReservationCommand;
import pm.practice.cinema.dto.outgoing.ReservationListItem;
import pm.practice.cinema.service.ReservationService;
import pm.practice.cinema.validation.ReservationCommandValidator;

import java.util.List;

@Controller
@RequestMapping("/api/reservations")
public class ReservationController {

    private ReservationService reservationService;
    private ReservationCommandValidator reservationCommandValidator;

    @Autowired
    public ReservationController(ReservationService reservationService, ReservationCommandValidator reservationCommandValidator) {
        this.reservationService = reservationService;
        this.reservationCommandValidator = reservationCommandValidator;
    }
    @InitBinder("reservationCommand")
    public void initBinderReservationCommand(WebDataBinder binder) {
        binder.addValidators(reservationCommandValidator);
    }

    @PostMapping
    public ResponseEntity addReservation (@RequestBody @Valid ReservationCommand reservationCommand) {
        reservationService.addReservation(reservationCommand);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ReservationListItem>> getAllReservations(){
        return new ResponseEntity<>(reservationService.getAllReservations(), HttpStatus.OK);
    }
}
