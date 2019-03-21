import {Component, OnInit} from "@angular/core";
import {Subscription} from "rxjs/internal/Subscription";
import {ActivatedRoute, Router} from "@angular/router";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {BillingAccountService} from "../../../../services/billing-account.service";
import {BillingAccount} from "../../models/billing-account";

@Component({
  selector: "app-billing-details",
  templateUrl: "./billing-details.component.html"
})
export class BillingDetailsComponent implements OnInit {

  billingAccount: BillingAccount;
  ready: boolean = false;
  private subscriptions: Subscription[] = [];


  constructor(private billingAccountService: BillingAccountService,
              private activateRoute: ActivatedRoute,
              private loadingService: Ng4LoadingSpinnerService,
              private router: Router) {
  }

  ngOnInit() {
    const id = this.activateRoute.snapshot.params['id'];

    if (id) {
      this.loadingService.show();

      this.subscriptions.push(this.billingAccountService.getBillingAccountById(id).subscribe(ba => {
          this.billingAccount = ba;
          this.ready = true;
          this.loadingService.hide();
        },
        error => {
          this.router.navigate(['/error'], {});
        }));
    } else {
      this.router.navigate(['/error'], {});
    }

  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}
