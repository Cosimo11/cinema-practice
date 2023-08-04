import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ScreeningService} from "../../services/screening.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-screening-form',
  templateUrl: './screening-form.component.html',
  styleUrls: ['./screening-form.component.css']
})
export class ScreeningFormComponent {

  screeningForm: FormGroup;

  constructor(private screeningService: ScreeningService,
              private formBuilder: FormBuilder,
              private router: Router
              ) {

    this.screeningForm = formBuilder.group({
        title: ['', Validators.required],
        screeningDate: ['', Validators.required],
        totalSeat: [0, Validators.required],
        pictureUrl: ['']
      }
    )

  }

  onSubmit() {
    const data = this.screeningForm.value;
    this.screeningService.addScreening(data).subscribe({
      next: value => {},
      error: err => console.log(err),
      complete: () => {console.log('Screening successfully added');
      this.router.navigate(['screening-list'])}
    })



    }
  }
