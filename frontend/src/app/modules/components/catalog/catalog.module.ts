import { NgModule } from '@angular/core';
import {CatalogComponent} from "./components/catalog.component";
import {SharedModule} from "../../../shared/shared.module";
import {CommonModule} from "@angular/common";
import {ChanelService} from "../../../services/chanel.service";
import {FormsModule} from "@angular/forms";

@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    FormsModule
  ],
  declarations: [
CatalogComponent
],
providers: [ChanelService],
exports: [CatalogComponent]
})
export class CatalogModule { }
