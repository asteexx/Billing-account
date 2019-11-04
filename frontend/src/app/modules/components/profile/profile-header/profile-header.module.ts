import { NgModule } from '@angular/core';
import {ProfileHeaderComponent} from "./components/profile-header.component";

import {SharedModule} from "../../../../shared/shared.module";

import {NavigationTabsModule} from "../../profile-tabs-navigation/navigation-tabs.module";




@NgModule({
  imports: [ SharedModule, NavigationTabsModule
  ],
  declarations: [ProfileHeaderComponent],
  exports: [ProfileHeaderComponent],
  providers: []


})
export class ProfileHeaderModule {
  value: string;
  href: string;
}
