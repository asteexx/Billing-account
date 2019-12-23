import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {SubscriptionOnChanel} from "../modules/components/active-chanels/subscription/subscriptionOnChanel";

@Injectable()
// Data service
export class SubscriptionService {


  constructor(private http: HttpClient) {
  }

  getAllSubscriptions(): Observable<SubscriptionOnChanel> {

    return this.http.get<SubscriptionOnChanel>('/api/subscriptions');
  }

  subscribeOnChanel(content: SubscriptionOnChanel): Observable<SubscriptionOnChanel> {

    return this.http.post<SubscriptionOnChanel>('/api/subscriptions', content);
  }

  unsubscribeFromChanel(idChanel: number, idSubscriber: number): Observable<void> {
    return this.http.delete<void>('/api/subscriptions/' + idChanel + '/' + idSubscriber);
  }

}
