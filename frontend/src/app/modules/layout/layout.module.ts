import { NgModule } from "@angular/core";
import {RouterModule} from "@angular/router";
import {BillingDetailsViewComponent} from "./components/billing-details/billing-details-view.component";

import {NotFoundComponent} from "./components/404/not-found.component";

import {HomeComponent} from "./components/home/home.component";

import { CatalogPageComponent } from "./components/catalog-page/catalog-page.component";

import { RegistrationPageComponent } from "./components/registration-page/registration-page.component";

import {AboutPageComponent} from "./components/about-page/about-page.component";

import { ProfilePageComponent } from './components/profile-page/profile-page.component';


import { CatalogModule} from "../components/catalog/catalog.module"

import { RegistrationFormModule} from "../components/registration-form/registration-form.module"

import {BillingAccountModule} from "../components/billing-account/billing-account.module";

import {HeaderModule} from "../components/common/header/header.module";

import {NavBarModule} from "../components/common/nav-bar/nav-bar.module";

import {HomeBodyModule} from "../components/home-body/home-body.module";

import {AboutModule} from "../components/about/about.module";

import {ProfileHeaderModule} from "../components/profile/profile-header/profile-header.module";

import {ProfileBodyModule} from "../components/profile/profile-body/profile-body.module";




@NgModule({
  declarations: [
    HomeComponent,
    NotFoundComponent,
    BillingDetailsViewComponent,
    CatalogPageComponent,
    RegistrationPageComponent,
    AboutPageComponent,
    ProfilePageComponent,

  ],
  imports: [
    BillingAccountModule,
    HeaderModule,
    NavBarModule,
    HomeBodyModule,
    CatalogModule,
    RegistrationFormModule,
    AboutModule,
    ProfileHeaderModule,
    ProfileBodyModule,

    RouterModule

  ],
  providers: [],
  exports: [HomeComponent, NotFoundComponent, BillingDetailsViewComponent, CatalogPageComponent, RegistrationPageComponent,  AboutPageComponent, ProfilePageComponent]
})
export class LayoutModule {}
