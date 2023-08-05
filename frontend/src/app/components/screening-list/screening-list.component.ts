import {Component, OnInit} from '@angular/core';
import {ScreeningService} from "../../services/screening.service";
import {ScreeningListItemModel} from "../../models/screening-list-item-model";
import {Observable} from "rxjs";
import {formatDate} from "@angular/common";

@Component({
  selector: 'app-screening-list',
  templateUrl: './screening-list.component.html',
  styleUrls: ['./screening-list.component.css']
})
export class ScreeningListComponent implements OnInit {
  screeninglist: ScreeningListItemModel[] = [];

  constructor(private screeningService: ScreeningService) {
  }


  ngOnInit(): void {
    this.screeningService.getAllScreenings().subscribe({
      next: data => {
        this.screeninglist = data;
      }
    })
  }


}
