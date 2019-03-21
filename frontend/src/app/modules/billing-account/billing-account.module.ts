import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {Ng4LoadingSpinnerModule} from 'ng4-loading-spinner';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {BillingAccountService} from '../../services/billing-account.service';
import {BillingAccountsComponent} from './components/table/billing-accounts.component';
import {BillingDetailsComponent} from './components/details/billing-details.component';

@NgModule({
  declarations: [
    BillingAccountsComponent,
    BillingDetailsComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
    Ng4LoadingSpinnerModule.forRoot(),

  ],

  providers: [BillingAccountService],
  exports: [BillingAccountsComponent, BillingDetailsComponent]
})
export class BillingAccountModule {
}
