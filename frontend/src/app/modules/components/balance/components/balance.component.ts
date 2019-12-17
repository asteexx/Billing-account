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

@Component({
  selector: 'app-balance',
  templateUrl: './balance.component.html',
  styleUrls: ['./balance.component.css']
})
export class BalanceComponent implements OnInit {
  public companies: Company[];
  private currentUser: UserModel;
  private company: Company;
  public eWallet: EWallet;
  public editableEWallet: EWallet = new EWallet();
  private subscriptions: Subscription[] = [];
  addedMoney: number;



  constructor(private storageService: StorageService,
              private  eWalletService: EWalletService,
  ) {
  }

  ngOnInit() {

  }

  @Input()
  moneyAmount: number;


  private loadWallets(): void {
    this.subscriptions.push(this.eWalletService.getAllWallets().subscribe(() => {
      console.log(this.eWallet);

    }));
  }


  // public  function once(fn, context) {
  //   var result;
  //   return function() {
  //     if (fn) {
  //       result = fn.apply(context || this, arguments);
  //       fn = null;
  //     }
  //     return result;
  //   };
  // }

  public showBalance () {
    let user = JSON.parse(localStorage.getItem("currentUser"));
    // console.log(user)
    // if()
    let eWalletByIdUser = this.eWalletService.getUsersWallet(user.idUser);

    // let eWalletsByIdUser = user.eWalletsByIdUser[0];
    // this.editableEWallet = EWallet.cloneBase(eWalletsByIdUser);


    eWalletByIdUser.subscribe(eWalletByIdUser => {

        let activeMoney = eWalletByIdUser.moneyAmmount
//       let strMoney = activeMoney.toString();
// //      // console.log(strMoney);
        this.moneyAmount = activeMoney;
    });

    }

    // console.log(eWalletsByIdUser)
//
//     let money = eWalletsByIdUser.map(a => a.moneyAmmount);
// // console.log(money);
//      let strMoney = activeMoney.toString();
// //      // console.log(strMoney);
//      this.moneyAmount = strMoney;



  public addMoney() {
    let user: User = JSON.parse(localStorage.getItem("currentUser"));
    // console.log(user)
    // if()
    let eWalletsByIdUser = user.eWalletsByIdUser[0];

    // let userWallet = this.eWalletService.getUsersWallet(userId)
    // this.editableEWallet = EWallet.cloneBase(userWallet);
    //  console.log(userWallet);
    // let user = JSON.parse(localStorage.getItem("currentUser"));
    // let wallet: EWallet = new EWallet();

    let ammount = +this.addedMoney;
    console.log(ammount);
    let edittedMoneyAmmount = +this.moneyAmount;
    console.log(edittedMoneyAmmount);
    let newMoneyAmmount = edittedMoneyAmmount + ammount;
    console.log(newMoneyAmmount);

    // wallet = user.eWalletsByIdUser;
    // this.editableEWallet = EWallet.cloneBase(userWallet);
// let stringWallet = JSON.stringify(wallet);
//     console.log(stringWallet);
    this.editableEWallet = EWallet.cloneBase(eWalletsByIdUser);
    this.editableEWallet.moneyAmmount = newMoneyAmmount;
    this.subscriptions.push(this.eWalletService.saveWallet(this.editableEWallet).subscribe((eWallet) => {
      user.eWalletsByIdUser[0] = eWallet;
      this.storageService.setUser(user);
      // localStorage.setItem("currentUser", user);
    }));
  }

  getUsersWallet
  // onSubmit() {
  //   console.log(this.addedMoney);
  //   return this.addedMoney;
  //
  // }


}

