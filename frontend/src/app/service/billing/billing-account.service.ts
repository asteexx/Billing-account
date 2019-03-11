import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {BillingAccount} from "../../model/billing-account";

@Injectable({
  providedIn: 'root'
})
// Data service
export class BillingAccountService { //todo create interface

  constructor(private http: HttpClient) {
  }

  // Ajax request for billing account data
  getBillingAccounts(): Observable<BillingAccount[]> {
    return this.http.get<BillingAccount[]>('/api/ba');
  }

  saveBillingAccount(billingAccount: BillingAccount): Observable<BillingAccount> {
    return this.http.post<BillingAccount>('/api/ba', billingAccount);
  }

  deleteBillingAccount(billingAccountId: string): Observable<void> {
    return this.http.delete<void>('/api/ba/' + billingAccountId);
  }

}
