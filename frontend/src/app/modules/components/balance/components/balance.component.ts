import { Component } from '@angular/core';
import {Company} from "../../catalog/models/company";
import {UserModel} from "../../common/nav-bar/models/user.model";
import {User} from "../../registration-form/models/user";

@Component({
  selector: 'app-balance',
  templateUrl: './balance.component.html',
  styleUrls: ['./balance.component.css']
})
export class BalanceComponent {
  public companies: Company[];
  private currentUser: UserModel;
  private  company: Company;
}
