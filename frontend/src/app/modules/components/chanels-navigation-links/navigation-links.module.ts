import { NgModule } from '@angular/core';
import {CommonModule} from "@angular/common";

import {SharedModule} from "../../../shared/shared.module";
import {NavigationLinksComponent} from "./navigation-links.component";


@NgModule({
  imports: [SharedModule, CommonModule
  ],
  declarations: [
    NavigationLinksComponent
  ],
  providers: [],
  exports: [ NavigationLinksComponent]
})
export class NavigationLinksModule { }
