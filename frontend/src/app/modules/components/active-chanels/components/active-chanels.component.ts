import {Component, OnInit, TemplateRef} from '@angular/core';
import {Catalog} from "../../catalog/models/catalog";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {ChanelService} from "../../../../services/chanel.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";

@Component({
  selector: 'app-active-chanels',
  templateUrl: './active-chanels.component.html',
  styleUrls: ['./active-chanels.component.css']
})
export class ActiveChanelsComponent implements OnInit{
  public editMode = false;
  public catalogs: Catalog[];
  public editableCatalog: Catalog = new Catalog();
  // public editCatalog: Catalog = new Catalog();
  public modalRef: BsModalRef; //we need a variable to keep a reference of our modal. This is going to be used to close the modal.

  private subscriptions: Subscription[] = [];




  // Dependency injection for ChanelService into Chanel
  constructor(private chanelService: ChanelService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) { //to show the modal, we also need the ngx-bootstrap service
  }

  // Calls on component init
  ngOnInit() {
    this.loadChanels();


  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>,catalog : Catalog): void {

    if (catalog) {
      this.editMode = true;
      this.editableCatalog = Catalog.cloneBase(catalog);
    } else {
      this.refreshCatalog();
      this.editMode = false;
    }

    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
                                                      // we keep the modal reference and pass the template local name to the modalService.
  }

  public _addChanel(): void {
    this.loadingService.show();
    this.subscriptions.push(this.chanelService.saveChanel(this.editableCatalog).subscribe(() => {
      this._updateChanels();
      this.refreshCatalog();
      this._closeModal();
      this.loadingService.hide();

    }));
  }


  public _updateChanels(): void {
    this.loadChanels();
  }


  public _deleteChanel(catalogId: string): void {
    this.loadingService.show();
    this.subscriptions.push(this.chanelService.deleteChanel(catalogId).subscribe(() => {
      this._updateChanels();
    }));
  }

  private refreshCatalog(): void {
    this.editableCatalog = new Catalog();
  }

  private loadChanels(): void {
    this.loadingService.show();
    // Get data from BillingAccountService
    this.subscriptions.push(this.chanelService.getAllChanels().subscribe(chanels => {
      // Parse json response into local array
      this.catalogs = chanels as Catalog[];
      // Check data in console
      console.log(this.catalogs);// don't use console.log in angular :)
      this.loadingService.hide();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }


}
