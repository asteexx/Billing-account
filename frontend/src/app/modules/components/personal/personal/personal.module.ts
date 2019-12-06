import { NgModule } from '@angular/core';
import {PersonalComponent} from "../personal.component";
import {SharedModule} from "../../../../shared/shared.module";



@NgModule({
  imports: [
    SharedModule

  ],
  declarations: [
    PersonalComponent
  ],
  exports: [
    PersonalComponent
  ]
})
export class PersonalModule { }
