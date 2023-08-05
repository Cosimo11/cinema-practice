import {Component, OnInit} from '@angular/core';
import {ScreeningService} from "../../services/screening.service";
import {ScreeningTitlesItemModel} from "../../models/screening-titles-item-model";
import {FormBuilder, FormControl, FormGroup, FormsModule, Validators} from "@angular/forms";
import {ReservationService} from "../../services/reservation.service";
import {validationHandler} from "../../utils/validation-handler";

@Component({
  selector: 'app-reservation-form',
  templateUrl: './reservation-form.component.html',
  styleUrls: ['./reservation-form.component.css']
})
export class ReservationFormComponent implements OnInit {

  registrationForm: FormGroup;

  screeningOptions: ScreeningTitlesItemModel[] =[];


  constructor(
    private screeningService: ScreeningService,
    private reservationService: ReservationService,
    private formBuilder: FormBuilder,
  ) {
    this.registrationForm = formBuilder.group({
      name: new FormControl('', [Validators.required]),
      numberOfSeats: new FormControl('', [Validators.required, Validators.min(1), Validators.max(155)]),
      screeningId: new FormControl('', [Validators.required])
    })

  }

  ngOnInit(): void {
    this.screeningService.getAllScreeningTitles().subscribe({
      next: value => this.screeningOptions = value
    })
  }
  saveReservation() {
    const data = this.registrationForm.value;
    console.log(data);
    this.reservationService.saveReservation(data).subscribe({
      next: ()=> {console.log(data)},
      error: err => {
        validationHandler(err, this.registrationForm); console.log(err.error.fieldErrors);
        console.log(this.registrationForm.get('numberOfSeats')?.errors);
      },
      complete: ()=>{console.log('Reservation saved');
      this.registrationForm.reset()}

    })

  }
}
