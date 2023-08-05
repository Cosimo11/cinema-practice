import {Component} from '@angular/core';
import {ReservationService} from "../../services/reservation.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {


  constructor(reservationService: ReservationService) {
  }



}
