import {Component, Input, Output} from '@angular/core';

import {ProfileHeaderModule} from "../../profile/profile-header/profile-header.module";
import {StorageService} from "../../../../services/security/storage.service";
import {UserService} from "../../../../services/security/user-service";

@Component({
  selector: 'app-navigation-tabs',
  templateUrl: './navigation-tabs.component.html',
  styleUrls: ['./navigation-tabs.component.css']
})
export class NavigationTabsComponent  {
  constructor(private storageService: StorageService) {
  }
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
