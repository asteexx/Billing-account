import { NgModule } from '@angular/core';
import {RegisterAdminComponent} from "./components/register-admin.component";
import {SharedModule} from "../../../../shared/shared.module";


@NgModule({
  imports: [
    SharedModule

  ],
  declarations: [
    RegisterAdminComponent
  ],
  exports: [
    RegisterAdminComponent
  ]
})
export class RegisterAdminModule {

}
