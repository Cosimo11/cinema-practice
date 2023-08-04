import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ScreeningFormComponent} from "./components/screening-form/screening-form.component";
import {ScreeningListComponent} from "./components/screening-list/screening-list.component";

const routes: Routes = [
  {path: 'screening-form', component: ScreeningFormComponent },
  {path: 'screening-list', component: ScreeningListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
