import {NgModule} from '@angular/core';
import {AddChanelFormComponent} from "./components/add-chanel-form.component";
import {SharedModule} from "../../../shared/shared.module";
import {FormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";




@NgModule({
  imports: [
    SharedModule,
    FormsModule,
    CommonModule,


  ],
  declarations: [
    AddChanelFormComponent
  ],
  exports: [
    AddChanelFormComponent
  ]
})
export class AddChanelFormModule {

}
