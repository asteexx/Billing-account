import {NgModule} from '@angular/core';
import {AddChanelFormComponent} from "./components/add-chanel-form.component";
import {SharedModule} from "../../../shared/shared.module";




@NgModule({
  imports: [
    SharedModule

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
