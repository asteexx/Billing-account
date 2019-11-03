import { NgModule } from "@angular/core";
import {NavBarComponent} from "./components/nav-bar.component";
import {SharedModule} from "../../../../shared/shared.module";


@NgModule({
declarations: [
NavBarComponent
],
imports: [
    SharedModule
],
providers: [],
exports: [NavBarComponent]
})
export class NavBarModule {
  value: string;
  href: string;
}
