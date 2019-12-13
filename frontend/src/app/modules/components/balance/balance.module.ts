import { NgModule } from '@angular/core';
import {BalanceComponent} from "./components/balance.component";
import {SharedModule} from "../../../shared/shared.module";
import {FormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";



@NgModule({
  imports: [
    SharedModule,
    FormsModule,
    CommonModule

  ],
  declarations: [
    BalanceComponent
  ],
  exports: [
    BalanceComponent
  ]
})
export class BalanceModule { }
