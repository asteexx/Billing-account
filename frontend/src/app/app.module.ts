import { BrowserModule } from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import { BsDropdownModule } from "ngx-bootstrap/dropdown";
import { TooltipModule } from "ngx-bootstrap/tooltip";
import { ModalModule } from "ngx-bootstrap/modal";
import { FormsModule } from "@angular/forms";

import { AppComponent } from "./app.component";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {RouterModule, Routes} from "@angular/router";
import {NotFoundComponent} from "./modules/layout/components/404/not-found.component";
import {LayoutModule} from "./modules/layout/layout.module";

import {HomeComponent} from "./modules/layout/components/home/home.component";

import { CatalogPageComponent } from "./modules/layout/components/catalog-page/catalog-page.component";

import { RegistrationPageComponent } from "./modules/layout/components/registration-page/registration-page.component";

import { AboutPageComponent } from './modules/layout/components/about-page/about-page.component';


import { ProfilePageComponent } from "./modules/layout/components/profile-page/profile-page.component";
import {NavBarModule} from "./modules/components/common/nav-bar/nav-bar.module";
import {SharedModule} from "./shared/shared.module";
import {CanActivateService} from "./services/security/can-activate.service";
import {UserService} from "./services/security/user-service";
import {APIInterceptor} from "./interceptors/api-interceptor";




const appRoutes: Routes = [
  {path: "", component: HomeComponent},
  {path: "home", component: HomeComponent , canActivate: [CanActivateService]},
  {path: "catalog", component: CatalogPageComponent},
  {path: "registration", component: RegistrationPageComponent},
  {path: "about", component: AboutPageComponent},
  {path: "profile", component: ProfilePageComponent},
  {path: "**", component: NotFoundComponent}

];

@NgModule({
  declarations: [
    AppComponent,

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
    NavBarModule,
    SharedModule,

  ],
  providers: [UserService,
    APIInterceptor, {

    provide: HTTP_INTERCEPTORS,
    useClass: APIInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent],

})
export class AppModule {

}
