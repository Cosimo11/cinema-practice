import {Component, OnInit} from '@angular/core';
import {ReservationListItemModel} from "../../models/reservation-list-item-model";
import {ReservationService} from "../../services/reservation.service";

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css']
})
export class ReservationListComponent implements OnInit{
 reservationList: ReservationListItemModel[]=[];


  constructor(private reservationService: ReservationService) {
  }

  ngOnInit(): void {
    this.reservationService.getAllReservations().subscribe({
      next: data => {
        this.reservationList = data;
      }
    })

  }

}
