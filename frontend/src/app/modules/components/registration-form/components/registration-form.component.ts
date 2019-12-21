import {Component, OnInit} from '@angular/core';
import {SharedModule} from "../../../../shared/shared.module";
import {User} from "../models/user";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {UserService} from "../../../../services/security/user-service";
import {Subscription} from "rxjs";
import {Roles} from "../models/roles";
import {CompanyService} from "../../../../services/companyService";
import {Company} from "../../catalog/models/company";
import {FormControl, FormGroup, Validators} from "@angular/forms";



@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',

})
export class RegistrationFormComponent implements OnInit {
  public user: User = new User();
  public roles: Roles[] = [{name: 'CUSTOMER'}, {name: 'COMPANY'}];
  public companies: Company[] = [];
  private subscriptions: Subscription[] = [];

  registerForm: FormGroup = new FormGroup({
    "login": new FormControl("", Validators.required),
    "email": new FormControl("", [Validators.required, Validators.email]),
    "password": new FormControl("", Validators.required),
    "role": new FormControl("", Validators.required),
    "company": new FormControl("", Validators.required),
  });


  constructor(private userService: UserService,
              private companyService: CompanyService,
              private loadingService: Ng4LoadingSpinnerService,) {

  }

  public _addUser(user: User): void {
    this.loadingService.show();

    this.subscriptions.push(this.userService.saveUser(this.user).subscribe(() => {

      this.refreshUser()
      this.loadingService.hide();
     this.redirect()
    }));
  }

  public loadCompanies() {

    this.companyService.getAllCompanies().subscribe(companies => this.companies = companies);

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
    this.loadCompanies()
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}
