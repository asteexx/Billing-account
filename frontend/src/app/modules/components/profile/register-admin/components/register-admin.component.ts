import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Subscription} from "rxjs";
import {Company} from "../../../catalog/models/company";
import {CompanyService} from "../../../../../services/companyService";


@Component({
  selector: 'app-register-admin',
  templateUrl: './register-admin.component.html',
  styleUrls: ['./register-admin.component.css']
})
export class RegisterAdminComponent implements OnInit {

  private subscriptions: Subscription[] = [];
  public company: Company = new Company();


  registerForm: FormGroup = new FormGroup({
    "name": new FormControl("", Validators.required),
    "description": new FormControl("", Validators.required),
  });

  constructor(private companyService: CompanyService
  ) {

  }

  ngOnInit() {

  }

  public createCompany(company: Company): void {
this.company.moneyOnBankAccount = 0;
    this.subscriptions.push(this.companyService.saveCompany(this.company).subscribe(() => {


    }));
  }
}
