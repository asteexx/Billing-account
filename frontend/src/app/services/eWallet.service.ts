import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CatalogPage} from "../shared/components/card/pageBe/catalogPage";
import {EWallet} from "../modules/components/balance/model/eWallet";
import {ChanelCatalog} from "../modules/components/catalog/models/chanelCatalog";

@Injectable()
// Data service
export class EWalletService {

  constructor(private http: HttpClient) {
  }

  // Ajax request for Wallets data
  getAllWallets(): Observable<EWallet> {

    return this.http.get<EWallet>('/api/e-wallet');
  }

  saveWallet(content: EWallet): Observable<EWallet> {

    return this.http.post<EWallet>('/api/e-wallet/add', content);
  }

  getUsersWallet(subscriberId: number): Observable<EWallet> {

    return this.http.get<EWallet>('/api/e-wallet/' + subscriberId);
  }


}
