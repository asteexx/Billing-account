import { NgModule } from '@angular/core';
import {RegistrationFormComponent} from "./components/registration-form.component";
import {SharedModule} from "../../../shared/shared.module";

@NgModule({
declarations: [
RegistrationFormComponent
],
  imports: [
    SharedModule

  ],
providers: [],
exports: [RegistrationFormComponent]
})
export class RegistrationFormModule {}

