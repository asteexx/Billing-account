import {Component, OnInit, TemplateRef} from '@angular/core';
import {ChanelCatalog} from "../../../modules/components/catalog/models/chanelCatalog";
import {Subscription} from "rxjs";
import {ChanelService} from "../../../services/chanel.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {NgbPaginationConfig} from "@ng-bootstrap/ng-bootstrap";
import {CatalogPage} from "./pageBe/catalogPage";
import {UserModel} from "../../../modules/components/common/nav-bar/models/user.model";
import {SubscriptionService} from "../../../services/subscription.service";
import {StorageService} from "../../../services/security/storage.service";


@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css'],
  providers: [NgbPaginationConfig]

})
export class CardComponent implements OnInit {

  public editMode = false;
  public catalogs: ChanelCatalog[];
  public editableCatalog: ChanelCatalog = new ChanelCatalog();
  private subscriptions: Subscription[] = [];
  private currentPage: number;
  private totalPages: number;
  private currentUser: UserModel;
  public modalRef: BsModalRef; //we need a variable to keep a reference of our modal. This is going to be used to close the modal.

  // Dependency injection for ChanelService into Chanel
  constructor(private chanelService: ChanelService,
              private storageService: StorageService,
              private subscriptionService: SubscriptionService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService,
              config: NgbPaginationConfig) {
    config.size = 'sm';
    config.boundaryLinks = true;//to show the modal, we also need the ngx-bootstrap service
  }

  ngOnInit() {
    this.currentPage = 0;
    this.loadChanels(this.currentPage);
  }


  private loadChanels(currentPage: number): void {
    this.loadingService.show();
    // Get data from BillingAccountService
    this.subscriptions.push(this.chanelService.getAllChanels(currentPage).subscribe(page => {
      // Parse json response into local array
      let catalogPage: CatalogPage;
      catalogPage = page as CatalogPage;
      this.catalogs = catalogPage.content;
      this.totalPages = catalogPage.totalPages;
      // Check data in console
      console.log(this.catalogs);// don't use console.log in angular :)
      this.loadingService.hide();
    }));
  }

  public showNextPage() {
    this.currentPage++;
    this._updateChanels();
  }

  public showPreviousPage() {
    this.currentPage--;
    this._updateChanels();
  }


  public _updateChanels(): void {
    this.loadChanels(this.currentPage);
  }


  public _deleteChanel(catalogId: string): void {
    this.loadingService.show();
    this.subscriptions.push(this.chanelService.deleteChanel(catalogId).subscribe(() => {
      this._updateChanels();
    }));
  }


  public _addChanel(): void {
    this.loadingService.show();
    console.log(1111);
    console.log(this.editableCatalog);
    this.subscriptions.push(this.chanelService.saveChanel(this.editableCatalog).subscribe(() => {
      this._updateChanels();
      this.refreshCatalog();
      this._closeModal();
      this.loadingService.hide();

    }));
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>, catalog: ChanelCatalog): void {

    if (catalog) {
      this.editMode = true;
      this.editableCatalog = ChanelCatalog.cloneBase(catalog);
    } else {
      this.refreshCatalog();
      this.editMode = false;
    }

    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
                                                      // we keep the modal reference and pass the template local name to the modalService.
  }
  private refreshCatalog(): void {
    this.editableCatalog = new ChanelCatalog();
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }


}
