import { NgModule } from '@angular/core';
import {CatalogComponent} from "./components/catalog.component";
import {SharedModule} from "../../../shared/shared.module";

@NgModule({
  imports: [SharedModule
  ],
  declarations: [
CatalogComponent
],
providers: [],
exports: [CatalogComponent]
})
export class CatalogModule { }
