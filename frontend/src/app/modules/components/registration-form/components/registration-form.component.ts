import {Component, OnInit} from '@angular/core';
import {SharedModule} from "../../../../shared/shared.module";
import {User} from "../models/user";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {UserService} from "../../../../services/security/user-service";
import {Subscription} from "rxjs";
import {Roles} from "../models/roles";

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',

})
export class RegistrationFormComponent implements OnInit {
  public user: User = new User();
  public roles: Roles[] = [{name: 'CUSTOMER'},{ name: 'COMPANY'}];
  private subscriptions: Subscription[] = [];

  constructor(private userService: UserService,
              private loadingService: Ng4LoadingSpinnerService,) {

  }

  public _addUser(): void {
    this.loadingService.show();

    if (this.user.role =="COMPANY"){
      this.user.idCompany === this.user.idUser;
      this.subscriptions.push(this.userService.saveUser(this.user).subscribe(() => {
        this.refreshUser()
        this.loadingService.hide();
        this.redirect()
      }));
    }
    this.subscriptions.push(this.userService.saveUser(this.user).subscribe(() => {
      this.refreshUser()
      this.loadingService.hide();
      this.redirect()
    }));
  }

  public refreshUser(): void {
    this.user = new User();
  }

  public redirect(): void {
    window.location.href = '/home';
  }

  import() {
    SharedModule
  }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}
