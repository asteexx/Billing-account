import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BillingAccountsComponent } from './billing-accounts.component';

describe('BillingAccountsComponent', () => {
  let component: BillingAccountsComponent;
  let fixture: ComponentFixture<BillingAccountsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BillingAccountsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BillingAccountsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
