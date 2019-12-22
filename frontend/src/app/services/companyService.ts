import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Company} from "../modules/components/catalog/models/company";
import {EWallet} from "../modules/components/balance/model/eWallet";
import {ChanelCatalog} from "../modules/components/catalog/models/chanelCatalog";

@Injectable()
// Data service
export class CompanyService {

  constructor(private http: HttpClient) {
  }

  // Ajax request for Wallets data

  getCompanyById(idCompany: number): Observable<Company> {

    return this.http.get<Company>('/api/companies/' + idCompany);
  }

  getAllCompanies() {

    return this.http.get<Company[]>('/api/companies');
  }

  saveCompany(content: Company): Observable<Company> {

    return this.http.post<Company>('/api/companies/add', content);
  }
}
