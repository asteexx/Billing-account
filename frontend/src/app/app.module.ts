import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { BsDropdownModule } from "ngx-bootstrap/dropdown";
import { TooltipModule } from "ngx-bootstrap/tooltip";
import { ModalModule } from "ngx-bootstrap/modal";
import { FormsModule } from "@angular/forms";

import { AppComponent } from "./app.component";
import {HttpClientModule} from "@angular/common/http";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {RouterModule, Routes} from "@angular/router";
import {BillingDetailsViewComponent} from "./modules/layout/components/billing-details/billing-details-view.component";
import {NotFoundComponent} from "./modules/layout/components/404/not-found.component";
import {LayoutModule} from "./modules/layout/layout.module";

import {HomeComponent} from "./modules/layout/components/home/home.component";

import { CatalogPageComponent } from "./modules/layout/components/catalog-page/catalog-page.component";

import { RegistrationPageComponent } from "./modules/layout/components/registration-page/registration-page.component";

import { AboutPageComponent } from './modules/layout/components/about-page/about-page.component';

import {HeaderModule} from "./modules/components/common/header/header.module";

import { ProfilePageComponent } from "./modules/layout/components/profile-page/profile-page.component";
import {NavBarModule} from "./modules/components/common/nav-bar/nav-bar.module";
import {SharedModule} from "./shared/shared.module";
import { Chanel } from './services/chanel.service/chanel.service.component';





const appRoutes: Routes = [
  {path: "", component: HomeComponent},
  {path: "home", component: HomeComponent},
  {path: "billing-details/:id", component: BillingDetailsViewComponent},
  {path: "catalog", component: CatalogPageComponent},
  {path: "registration", component: RegistrationPageComponent},
  {path: "about", component: AboutPageComponent},
  {path: "profile", component: ProfilePageComponent},
  {path: "**", component: NotFoundComponent}

];

@NgModule({
  declarations: [
    AppComponent,
    Chanel.ServiceComponent,










  ],
  imports: [
    BrowserModule,
    FormsModule,
    LayoutModule,
    HttpClientModule,
    Ng4LoadingSpinnerModule.forRoot(),
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot(),
    RouterModule.forRoot(appRoutes),
    HeaderModule,
    NavBarModule,
    SharedModule
  ],
  providers: [],
  bootstrap: [AppComponent],

})
export class AppModule { }
