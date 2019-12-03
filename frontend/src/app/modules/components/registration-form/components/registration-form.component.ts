import {Component, OnInit} from '@angular/core';
import {SharedModule} from "../../../../shared/shared.module";
import {User} from "../models/user";
import {ChanelService} from "../../../../services/chanel.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {UserService} from "../../../../services/security/user-service";
import {Subscription} from "rxjs";
import {UserAddService} from "../../../../services/userAdd.service";

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',

})
export class RegistrationFormComponent implements OnInit {
  public editableCatalog: User = new User();
  private subscriptions: Subscription[] = [];

  constructor(private userAddService: UserAddService,
              private loadingService: Ng4LoadingSpinnerService,){

  }

  public _addUser(): void {
    this.loadingService.show();
    this.subscriptions.push(this.userAddService.saveUser(this.editableCatalog).subscribe(() => {

      this.loadingService.hide();

    }));
  }

import(){
  SharedModule
}

  ngOnInit(): void {
  }
  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}
