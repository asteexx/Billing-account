import {Component, Input, Output} from '@angular/core';

import {ProfileHeaderModule} from "../../profile/profile-header/profile-header.module";
import {SharedModule} from "../../../../shared/shared.module";

@Component({
  selector: 'app-navigation-tabs',
  templateUrl: './navigation-tabs.component.html',
  styleUrls: ['./navigation-tabs.component.css']
})
export class NavigationTabsComponent  {

  @Input()
  navId: string;

  @Input()
  navTabsTitle: string;
  @Input()
  navLinks: ProfileHeaderModule[] = [];

  @Output()
  linkView='personal';

  import() {


}


}
