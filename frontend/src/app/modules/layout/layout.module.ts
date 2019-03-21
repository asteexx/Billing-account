import { NgModule } from "@angular/core";
import {BillingDetailsViewComponent} from "./components/billing-details/billing-details-view.component";
import {NotFoundComponent} from "./components/404/not-found.component";
import {HomeComponent} from "./components/home/home.component";
import {BillingAccountModule} from "../billing-account/billing-account.module";
import {HeaderModule} from "../header/header.module";
import {RouterModule} from "@angular/router";

@NgModule({
  declarations: [
    HomeComponent,
    NotFoundComponent,
    BillingDetailsViewComponent
  ],
  imports: [
    BillingAccountModule,
    HeaderModule,
    RouterModule
  ],
  providers: [],
  exports: [HomeComponent, NotFoundComponent, BillingDetailsViewComponent]
})
export class LayoutModule {}
