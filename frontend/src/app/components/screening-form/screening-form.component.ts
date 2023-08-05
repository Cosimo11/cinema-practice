import {Component} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ScreeningService} from "../../services/screening.service";
import {Router} from "@angular/router";
import {validationHandler} from "../../utils/validation-handler";

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
        title: new FormControl('', [Validators.required],),
        screeningDate: new FormControl([0], [Validators.required]),
        totalSeat: new FormControl('', [
          Validators.required,
          Validators.min(85),
          Validators.max(155)
        ]),
        pictureUrl: new FormControl('', [Validators.required])
      }
    )

  }

  onSubmit() {
    const data = this.screeningForm.value;
    this.screeningService.addScreening(data).subscribe({
      next: value => {
      },
      error: err => validationHandler(err, this.screeningForm),
      complete: () => {
        console.log('Screening successfully added');
        this.router.navigate(['screening-list'])
      }
    })


  }


}
