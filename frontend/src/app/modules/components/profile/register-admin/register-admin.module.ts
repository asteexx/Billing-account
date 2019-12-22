import { NgModule } from '@angular/core';
import {RegisterAdminComponent} from "./components/register-admin.component";
import {SharedModule} from "../../../../shared/shared.module";
import {ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";


@NgModule({
  imports: [
    SharedModule,
    ReactiveFormsModule,
    CommonModule

  ],
  declarations: [
    RegisterAdminComponent,
  ],
  exports: [
    RegisterAdminComponent
  ]
})
export class RegisterAdminModule {

}
