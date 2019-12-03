import {NgModule} from "@angular/core";
import {DropdownComponent} from "./components/dropdown/dropdown.component";
import {ButtonComponent} from "./components/button/button.component";
import {BrowserModule} from "@angular/platform-browser";
import { CardComponent } from './components/card/card.component';


import { InputComponent } from './components/input/input.component';
import {FormsModule} from "@angular/forms";
import {NgbPaginationModule} from "@ng-bootstrap/ng-bootstrap";

@NgModule({
  declarations: [DropdownComponent, ButtonComponent, CardComponent,  InputComponent],
  imports: [
    BrowserModule,
    FormsModule,
    NgbPaginationModule
  ],
  exports: [
    DropdownComponent,
    ButtonComponent,
    CardComponent,
    InputComponent,

  ]
})
export class SharedModule {

}
