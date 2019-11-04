import { NgModule } from "@angular/core";
import {HomeBodyComponent} from "./components/home-body.component";
import {SharedModule} from "../../../shared/shared.module";


@NgModule({
  declarations: [
    HomeBodyComponent
  ],
  imports: [
    SharedModule
  ],
  providers: [],
  exports: [HomeBodyComponent]
})
export class HomeBodyModule {

}
