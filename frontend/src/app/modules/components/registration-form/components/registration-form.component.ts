import {Component, OnInit} from '@angular/core';
import {SharedModule} from "../../../../shared/shared.module";
import {User} from "../models/user";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {UserService} from "../../../../services/security/user-service";
import {Subscription} from "rxjs";
import {NgModel} from "@angular/forms";

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',

})
export class RegistrationFormComponent implements OnInit {
  public editableCatalog: User = new User();
  private subscriptions: Subscription[] = [];

  constructor(private userService: UserService,
              private loadingService: Ng4LoadingSpinnerService,) {

  }

  public _addUser(login: NgModel, eMail: NgModel, password: NgModel): void {
    this.loadingService.show();
    this.subscriptions.push(this.userService.saveUser(this.editableCatalog).subscribe(() => {
      this.refreshUser()
      this.loadingService.hide();
      this.redirect()
    }));
  }

  public refreshUser(): void {
    this.editableCatalog = new User();
  }

  public redirect(): void {
    window.location.href = '/login';
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
