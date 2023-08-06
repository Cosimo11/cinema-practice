import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ScreeningCommandModel} from "../models/screening-command-model";
import {ScreeningListItemModel} from "../models/screening-list-item-model";
import {ScreeningTitlesItemModel} from "../models/screening-titles-item-model";
import {MovieSummaryItemModel} from "../models/movie-summary-item-model";

const BASE_URL = "http://localhost:8080/api/screenings"


@Injectable({
  providedIn: 'root'
})
export class ScreeningService {

  constructor(private http: HttpClient) {
  }


  addScreening(data: ScreeningCommandModel) {
    return this.http.post(BASE_URL, data);
  }


  getAllScreenings(): Observable<ScreeningListItemModel[]> {
    return this.http.get<ScreeningListItemModel[]>(BASE_URL);

  }

  getAllScreeningTitles(): Observable<ScreeningTitlesItemModel[]> {
    return this.http.get<ScreeningTitlesItemModel[]>(BASE_URL + '/screeningOption');
  }

  getSummaries():Observable<MovieSummaryItemModel[]> {
    return this.http.get<MovieSummaryItemModel[]>(BASE_URL + '/summaries')

  }
}
