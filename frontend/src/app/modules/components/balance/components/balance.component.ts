import {Component, Input} from '@angular/core';
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

@Input()
moneyAmount: number;


  public showBalance(){
    let user = JSON.parse(localStorage.getItem("currentUser"));
    console.log(user)
    let eWalletsByIdUser = user.eWalletsByIdUser;
    console.log(eWalletsByIdUser)

     let money = eWalletsByIdUser.map(a => a.moneyAmmount);
console.log(money);
      let strMoney = money.toString();
      console.log(strMoney);
      this.moneyAmount = strMoney;
  }



}

