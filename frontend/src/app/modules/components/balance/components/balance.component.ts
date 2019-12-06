import { Component } from '@angular/core';
import {Company} from "../../catalog/models/company";

@Component({
  selector: 'app-balance',
  templateUrl: './balance.component.html',
  styleUrls: ['./balance.component.css']
})
export class BalanceComponent {
  public companies: Company[];
}
