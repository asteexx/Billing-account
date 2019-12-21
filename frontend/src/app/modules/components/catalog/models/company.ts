
export class Company{
  idCompany: number;
  name: string;
  shortDescription: string;
  moneyOnBankAccount: number;


  static cloneBase(catalog: Company): Company {
    console.log(catalog);

    const clonedCompany: Company = new Company();
    clonedCompany.idCompany = catalog.idCompany;
    clonedCompany.name = catalog.name;
    clonedCompany.moneyOnBankAccount = catalog.moneyOnBankAccount;
    clonedCompany.shortDescription = catalog.shortDescription;

    return clonedCompany;
  }


}
