import { NgModule} from '@angular/core';
import {ActiveChanelsComponent} from "./components/active-chanels.component";
import {SharedModule} from "../../../shared/shared.module";

@NgModule({
  imports: [
    SharedModule

  ],
  declarations: [
    ActiveChanelsComponent
  ],
  exports: [
    ActiveChanelsComponent
  ]
})
export class ActiveChanelsModule{

}
