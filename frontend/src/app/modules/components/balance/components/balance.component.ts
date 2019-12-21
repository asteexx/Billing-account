import {Component, Input, OnInit} from '@angular/core';
import {Company} from "../../catalog/models/company";
import {UserModel} from "../../common/nav-bar/models/user.model";
import {User} from "../../registration-form/models/user";
import {setUTCOffset} from "ngx-bootstrap/chronos/units/offset";
import {StorageService} from "../../../../services/security/storage.service";
import {UserService} from "../../../../services/security/user-service";
import {ChanelCatalog} from "../../catalog/models/chanelCatalog";
import {EWallet} from "../model/eWallet";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {EWalletService} from "../../../../services/eWallet.service";
import {Subscription} from "rxjs";
import {CatalogPage} from "../../../../shared/components/card/pageBe/catalogPage";
import {CompanyService} from "../../../../services/companyService";

@Component({
  selector: 'app-balance',
  templateUrl: './balance.component.html',
  styleUrls: ['./balance.component.css'],

})
export class BalanceComponent implements OnInit {
  public usssser: User = new User();
  public activeUser: User = new User();
  public eWallet: EWallet;
  public editableEWallet: EWallet = new EWallet();
  private subscriptions: Subscription[] = [];
  addedMoney: number;

  constructor(private storageService: StorageService,
              private  eWalletService: EWalletService,
              private  companyService: CompanyService,
              private  userService: UserService,
  ) {
  }

  ngOnInit() {
    this.showBalance()
  }

  @Input()
  moneyAmount: number;
  @Input()
  easy_click: any;

  private loadWallets(): void {
    this.subscriptions.push(this.eWalletService.getAllWallets().subscribe(() => {
      console.log(this.eWallet);

    }));
  }

  public showBalance() {
    let user = JSON.parse(localStorage.getItem("currentUser"));
    if (user.role == "COMPANY") {
      let activeCompany = this.companyService.getCompanyById(user.idCompany);
      activeCompany.subscribe(activeCompany => {
        let shownMoneyAmmount = activeCompany.moneyOnBankAccount
        this.moneyAmount = shownMoneyAmmount;
        this.ngOnDestroy()
      })
    } else {
      let eWalletByIdUser = this.eWalletService.getUsersWallet(user.idUser);

      eWalletByIdUser.subscribe(eWalletByIdUser => {
        let activeMoney = eWalletByIdUser.moneyAmmount
        this.moneyAmount = activeMoney;
        this.ngOnDestroy()
      });

    }
  }

  public addMoney() {
    let user: User = JSON.parse(localStorage.getItem("currentUser"));
    let eWalletsByIdUser = user.eWalletsByIdUser[0];
    let ammount = +this.addedMoney;
    let edittedMoneyAmmount = +this.moneyAmount;
    let newMoneyAmmount = edittedMoneyAmmount + ammount;
    this.editableEWallet = EWallet.cloneBase(eWalletsByIdUser);
    this.editableEWallet.id = eWalletsByIdUser.id;
    this.editableEWallet.subscriberId = eWalletsByIdUser.subscriberId;
    this.editableEWallet.moneyAmmount = newMoneyAmmount;
    this.subscriptions.push(this.eWalletService.saveWallet(this.editableEWallet).subscribe((eWallet) => {
      user.eWalletsByIdUser[0] = eWallet;
      this.storageService.setUser(user);
    }));
  }

  public createWallet() {
    let user: User = JSON.parse(localStorage.getItem("currentUser"));
    let userId = user.idUser;
    this.editableEWallet.id = userId;
    this.editableEWallet.subscriberId = userId;
    this.editableEWallet.moneyAmmount = 0;
    this.subscriptions.push(this.eWalletService.saveWallet(this.editableEWallet).subscribe(() => {
        this.activeUser = User.cloneBase(user);
        this.activeUser.eWalletsByIdUser[0] = this.editableEWallet;
      this.storageService.setUser(user);
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}

