
export class Company{
  id: string;
  name: string;
  shortDescription: string;
  moneyOnBankAccount: string;


  static cloneBase(catalog: Company): Company {
    console.log(catalog);

    const clonedCompany: Company = new Company();
    clonedCompany.id = catalog.id;
    clonedCompany.name = catalog.name;
    clonedCompany.moneyOnBankAccount = catalog.moneyOnBankAccount;
    clonedCompany.shortDescription = catalog.shortDescription;

    return clonedCompany;
  }


}
