import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";


@Injectable()
// Data service
export class ChanelService {

  constructor(private http: HttpClient) {
  }

  // Ajax request for billing account data
  getAllChanels(): Observable<[]> {
    return this.http.get<BillingAccount[]>('/api/ba');
  }







}
