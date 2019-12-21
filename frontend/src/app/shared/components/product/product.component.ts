import {Component, Input, OnInit, TemplateRef} from '@angular/core';
import {SubscriptionOnChanel} from "../../../modules/components/active-chanels/subscription/subscriptionOnChanel";
import {SubscriptionService} from "../../../services/subscription.service";
import {Subscription} from "rxjs";
import {UserModel} from "../../../modules/components/common/nav-bar/models/user.model";
import {ChanelCatalog} from "../../../modules/components/catalog/models/chanelCatalog";
import {ChanelService} from "../../../services/chanel.service";
import {CatalogPage} from "../card/pageBe/catalogPage";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {BsModalRef, BsModalService} from "ngx-bootstrap";


@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.css'],
  providers: []

})
export class ProductComponent  implements OnInit{

  public subscriptionOnChanel: SubscriptionOnChanel;
  public editMode = false;
  public catalogs: ChanelCatalog[];
  public editableCatalog: ChanelCatalog = new ChanelCatalog();
  private subscriptions: Subscription[] = [];
  private currentPage: number;
  private currentUser: UserModel;
  public modalRef: BsModalRef; //we need a variable to keep a reference of our modal. This is going to be used to close the modal.
  private totalPages: number;

  // private subscriptionService: SubscriptionService ;


  constructor(private subscriptionService: SubscriptionService,
               private loadingService: Ng4LoadingSpinnerService,
              private chanelService: ChanelService,
                private modalService: BsModalService,
  ) {
  }

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
  @Input()
  userRole: string;

  ngOnInit(): void {
    this.getUSerRole();
  }

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


  public getUSerRole() {
    let user = JSON.parse(localStorage.getItem("currentUser"));
    this.userRole = user.role;
  }



}
