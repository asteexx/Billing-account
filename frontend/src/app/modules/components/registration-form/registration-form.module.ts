import { NgModule } from '@angular/core';
import {RegistrationFormComponent} from "./components/registration-form.component";
import {SharedModule} from "../../../shared/shared.module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BrowserModule} from "@angular/platform-browser";

@NgModule({
declarations: [
RegistrationFormComponent
],
  imports: [
    SharedModule,
    FormsModule,
    BrowserModule,
    ReactiveFormsModule

  ],
providers: [],
exports: [RegistrationFormComponent]
})
export class RegistrationFormModule {}

