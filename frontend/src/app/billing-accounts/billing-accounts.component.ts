import {Component, OnInit, TemplateRef} from '@angular/core';
import {BillingAccount} from "../model/billing-account";
import {BillingAccountService} from "../service/billing/billing-account.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs/internal/Subscription";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";

@Component({
  selector: 'app-billing-accounts',
  templateUrl: './billing-accounts.component.html'
})
export class BillingAccountsComponent implements OnInit {

  public editMode = false;

  public billingAccounts: BillingAccount[];
  public editableBa: BillingAccount = new BillingAccount();
  public modalRef: BsModalRef; //we need a variable to keep a reference of our modal. This is going to be used to close the modal.

  private subscriptions: Subscription[] = [];


  // Dependency injection for BillingAccountService into Billing
  constructor(private billingAccountService: BillingAccountService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) { //to show the modal, we also need the ngx-bootstrap service
  }

  // Calls on component init
  ngOnInit() {
    this.loadBillingAccounts();
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>, billingAccount: BillingAccount): void {

    if (billingAccount) {
      this.editMode = true;
      this.editableBa = BillingAccount.cloneBase(billingAccount);
    } else {
      this.refreshBa();
      this.editMode = false;
    }

    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
                                                      // we keep the modal reference and pass the template local name to the modalService.
  }

  public _addBillingAccount(): void {
    this.loadingService.show();
    this.subscriptions.push(this.billingAccountService.saveBillingAccount(this.editableBa).subscribe(() => {
      this._updateBillingAccounts();
      this.refreshBa();
      this._closeModal();
      this.loadingService.hide();

    }));
  }

  public _updateBillingAccounts(): void {
    this.loadBillingAccounts();
  }

  public _deleteBillingAccount(billingAccountId: string): void {
    this.loadingService.show();
    this.subscriptions.push(this.billingAccountService.deleteBillingAccount(billingAccountId).subscribe(() => {
      this._updateBillingAccounts();
    }));
  }

  private refreshBa(): void {
    this.editableBa = new BillingAccount();
  }

  private loadBillingAccounts(): void {
    this.loadingService.show();
    // Get data from BillingAccountService
    this.subscriptions.push(this.billingAccountService.getBillingAccounts().subscribe(accounts => {
      // Parse json response into local array
      this.billingAccounts = accounts as BillingAccount[];
      // Check data in console
      console.log(this.billingAccounts);// don't use console.log in angular :)
      this.loadingService.hide();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}
