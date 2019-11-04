import { NgModule } from '@angular/core';
import {CommonModule} from "@angular/common";


import {NavigationLinksComponent} from "./navigation-links.component";
import {AddChanelFormModule} from "../add-chanel-form/add-chanel-form.module";

import {ActiveChanelsModule} from "../active-chanels/active-chanels.module";


@NgModule({
  imports: [CommonModule, AddChanelFormModule, ActiveChanelsModule
  ],
  declarations: [
    NavigationLinksComponent
  ],
  providers: [],
  exports: [ NavigationLinksComponent]
})
export class NavigationLinksModule { }
