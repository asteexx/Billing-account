import { TestBed, inject } from '@angular/core/testing';

import { BillingAccountService } from './billing-account.service';

describe('BillingAccountService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BillingAccountService]
    });
  });

  it('should be created', inject([BillingAccountService], (service: BillingAccountService) => {
    expect(service).toBeTruthy();
  }));
});
