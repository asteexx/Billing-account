import {NgModule} from "@angular/core";
import {DropdownComponent} from "./components/dropdown/dropdown.component";
import {ButtonComponent} from "./components/button/button.component";
import {BrowserModule} from "@angular/platform-browser";
import { CardComponent } from './components/card/card.component';
import { NavigationTabsComponent } from '../modules/components/profile-tabs-navigation/navigation-tabs.component';

import { NavigationLinksComponent } from '../modules/components/chanels-navigation-links/navigation-links.component';
import { InputComponent } from './components/input/input.component';

@NgModule({
  declarations: [DropdownComponent, ButtonComponent, CardComponent, NavigationTabsComponent, NavigationLinksComponent, InputComponent],
  imports: [
    BrowserModule
  ],
  exports: [
    DropdownComponent,
    ButtonComponent,
    CardComponent,
    NavigationTabsComponent
  ]
})
export class SharedModule {

}
