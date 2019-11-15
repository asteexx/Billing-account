import { NgModule } from '@angular/core';
import {NavigationTabsComponent} from "./component/navigation-tabs.component";
import {CommonModule} from "@angular/common";
import {SharedModule} from "../../../shared/shared.module";
import {NavigationLinksModule} from "../chanels-navigation-links/navigation-links.module";
import {BalanceModule} from "../balance/balance.module";
import {PersonalModule} from "../personal/personal/personal.module";
import {RegisterAdminModule} from "../profile/register-admin/register-admin.module";




@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    NavigationLinksModule,
    BalanceModule,
    PersonalModule,
    RegisterAdminModule

  ],
  declarations: [
    NavigationTabsComponent
  ],
  exports: [
    NavigationTabsComponent
  ]
})
export class NavigationTabsModule { }
