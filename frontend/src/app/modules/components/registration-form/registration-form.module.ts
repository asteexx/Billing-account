import { NgModule } from '@angular/core';
import {RegistrationFormComponent} from "./components/registration-form.component";
import {SharedModule} from "../../../shared/shared.module";
import {FormsModule} from "@angular/forms";

@NgModule({
declarations: [
RegistrationFormComponent
],
  imports: [
    SharedModule,
    FormsModule

  ],
providers: [],
exports: [RegistrationFormComponent]
})
export class RegistrationFormModule {}

