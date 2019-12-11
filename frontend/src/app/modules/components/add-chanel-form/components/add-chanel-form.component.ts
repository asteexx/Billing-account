import {Component, OnInit, TemplateRef} from '@angular/core';
import {ChanelCatalog} from "../../catalog/models/chanelCatalog";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {ChanelService} from "../../../../services/chanel.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {CatalogPage} from "../../../../shared/components/card/pageBe/catalogPage";


@Component({
  selector: 'app-add-chanel-form',
  templateUrl: './add-chanel-form.component.html',
  styleUrls: ['./add-chanel-form.component.css']
})
export class AddChanelFormComponent implements OnInit {
  public editMode = false;
  public catalogs: ChanelCatalog[];
  public editableCatalog: ChanelCatalog = new ChanelCatalog();
  public modalRef: BsModalRef; //we need a variable to keep a reference of our modal. This is going to be used to close the modal.
  private totalPages: number;
  private subscriptions: Subscription[] = [];
  page: number = 0;

  // Dependency injection for ChanelService into Chanel
  constructor(private chanelService: ChanelService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) { //to show the modal, we also need the ngx-bootstrap service
  }

  // Calls on component init
  ngOnInit() {
    this.loadChanels(this.page);
  }

  private _closeModal(): void {
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

    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup// we keep the modal reference and pass the template local name to the modalService.
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
    this.loadChanels(this.page);
  }

  private refreshCatalog(): void {
    this.editableCatalog = new ChanelCatalog();
  }

  private loadChanels(currentPage: number): void {
    this.loadingService.show();
    // Get data from BillingAccountService
    this.subscriptions.push(this.chanelService.getAllChanels(currentPage).subscribe(page => {
      // Parse json response into local array
      let catalogPage: CatalogPage;
      catalogPage =  page as CatalogPage;
      this.catalogs = catalogPage.content;
      this.totalPages = catalogPage.totalPages;
      // Check data in console
      console.log(this.catalogs);// don't use console.log in angular :)
      this.loadingService.hide();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}
