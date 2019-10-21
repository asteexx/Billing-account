export class BillingAccount {
  id: string;
  address: string;
  username: string;
  email: string;

  static cloneBase(billingAccout: BillingAccount): BillingAccount {
    const clonedBillingAccount: BillingAccount = new BillingAccount();
    clonedBillingAccount.id = billingAccout.id;
    clonedBillingAccount.username = billingAccout.username;
    clonedBillingAccount.email = billingAccout.email;
    clonedBillingAccount.address = billingAccout.address;
    return clonedBillingAccount;
  }
}

export class BillingAccountStr {
}
