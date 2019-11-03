import { NgModule } from '@angular/core';
import {ProfileHeaderComponent} from "./components/profile-header.component";

import {SharedModule} from "../../../../shared/shared.module";



@NgModule({
  imports: [ SharedModule
  ],
  declarations: [ProfileHeaderComponent],
  exports: [ProfileHeaderComponent],
  providers: []


})
export class ProfileHeaderModule {
  value: string;
  href: string;
}
