import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ReservationCommandModel} from "../models/reservation-command-model";
import {Observable} from "rxjs";
import {ReservationListItemModel} from "../models/reservation-list-item-model";

const BASE_URL = "http://localhost:8080/api/reservations"
@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http: HttpClient) {
  }


  saveReservation(data: ReservationCommandModel) {
    return this.http.post(BASE_URL, data);

  }

  getAllReservations():Observable<ReservationListItemModel[]> {
    return this.http.get<ReservationListItemModel[]>(BASE_URL)

  }
}
