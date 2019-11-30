import {NgModule} from "@angular/core";
import {NavBarComponent} from "./components/nav-bar.component";
import {SharedModule} from "../../../../shared/shared.module";
import {StorageService} from "../../../../services/security/storage.service";
import {UserService} from "../../../../services/security/user-service";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";


@NgModule({
  declarations: [
    NavBarComponent
  ],
  imports: [
    SharedModule,
    HttpClientModule,
    FormsModule,
    CommonModule
  ],
  providers: [UserService, StorageService],
  exports: [NavBarComponent]
})
export class NavBarModule {
  value: string;
  href: string;
}
