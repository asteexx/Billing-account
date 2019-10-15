import { NgModule } from "@angular/core";
import {BillingDetailsViewComponent} from "./components/billing-details/billing-details-view.component";
import {NotFoundComponent} from "./components/404/not-found.component";
import {HomeComponent} from "./components/home/home.component";
import { CatalogPageComponent } from "./components/catalog-page/catalog-page.component";
import { RegistrationPageComponent } from "./components/registration-page/registration-page.component";
import { CatalogModule} from "../catalog/catalog.module"
import { RegistrationFormModule} from "../registration-form/registration-form.module"
import {BillingAccountModule} from "../billing-account/billing-account.module";
import {HeaderModule} from "../header/header.module";
import {NavBarModule} from "../nav-bar/nav-bar.module";
import {RouterModule} from "@angular/router";




@NgModule({
  declarations: [
    HomeComponent,
    NotFoundComponent,
    BillingDetailsViewComponent,
    CatalogPageComponent,
    RegistrationPageComponent
  ],
  imports: [
    BillingAccountModule,
    HeaderModule,
    NavBarModule,
    CatalogModule,
    RegistrationFormModule,
    RouterModule
  ],
  providers: [],
  exports: [HomeComponent, NotFoundComponent, BillingDetailsViewComponent, CatalogPageComponent, RegistrationPageComponent]
})
export class LayoutModule {}
