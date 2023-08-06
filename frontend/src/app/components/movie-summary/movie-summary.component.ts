import {Component, OnInit} from '@angular/core';
import {MovieSummaryItemModel} from "../../models/movie-summary-item-model";
import {ScreeningService} from "../../services/screening.service";

@Component({
  selector: 'app-movie-summary',
  templateUrl: './movie-summary.component.html',
  styleUrls: ['./movie-summary.component.css']
})
export class MovieSummaryComponent implements OnInit{
  summarylist: MovieSummaryItemModel [] = [];

  constructor(private screeningService:ScreeningService) {
  }

  ngOnInit(): void {
    this.screeningService.getSummaries().subscribe({
      next: data => {this.summarylist = data;
      }
    })

  }

}
