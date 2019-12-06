import { NgModule } from '@angular/core';
import {BalanceComponent} from "./components/balance.component";
import {SharedModule} from "../../../shared/shared.module";



@NgModule({
  imports: [
    SharedModule

  ],
  declarations: [
    BalanceComponent
  ],
  exports: [
    BalanceComponent
  ]
})
export class BalanceModule { }
