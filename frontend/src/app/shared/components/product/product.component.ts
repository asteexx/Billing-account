import {Component, Input} from '@angular/core';
import {SubscriptionOnChanel} from "../../../modules/components/active-chanels/subscription/subscriptionOnChanel";
import {SubscriptionService} from "../../../services/subscription.service";
import {Subscription} from "rxjs";
import {UserModel} from "../../../modules/components/common/nav-bar/models/user.model";
import {ChanelCatalog} from "../../../modules/components/catalog/models/chanelCatalog";
import {ChanelService} from "../../../services/chanel.service";


@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.css'],
  providers: []

})
export class ProductComponent {

  public subscriptionOnChanel: SubscriptionOnChanel;
  private subscriptions: Subscription[] = [];
  private currentUser: UserModel;
  // private subscriptionService: SubscriptionService ;
  public editableCatalog: ChanelCatalog = new ChanelCatalog();

  constructor(private subscriptionService: SubscriptionService){}
  @Input()
  chanelName: string;

  @Input()
  smallDiscription: string;

  @Input()
  price: string;

  @Input()
  id: number;

  @Input()
  companiesByOwner: string;

  public subscribeOnChanel() {

    // this.loadingService.show();
    let user = JSON.parse(localStorage.getItem("currentUser"));
    let idUser = user.idUser;
    console.log(idUser);
    let idProduct = this.id;
    console.log(idProduct);
    this.subscriptionOnChanel = new SubscriptionOnChanel();
    this.subscriptionOnChanel.idSubscriber = idUser;

    this.subscriptionOnChanel.idChanel = idProduct;
console.log(this.subscriptionOnChanel);
    this.subscriptions.push(this.subscriptionService.subscribeOnChanel(this.subscriptionOnChanel).subscribe(() => {

      this.refreshCatalog();
      // this.loadingService.hide();
    }));
  }

  private refreshCatalog(): void {
    this.editableCatalog = new ChanelCatalog();
  }
  public showSuccessForSubscription() {
  }

}
