export class User {

  idUser: number;
  login: string;
  eMail: string;
  password: number;
  role: string;
  idCompany: number;
  firstName: string;
  lastName: string;
  phoneNumber: number;
  adress: string;

 // private Collection<EWalletModel>eWalletsByIdUser;

  static cloneBase(user: User): User {
    const clonedUser: User = new User();
    clonedUser.idUser = user.idUser;
    clonedUser.login = user.login;
    clonedUser.eMail = user.eMail;
    clonedUser.password = user.password;
    clonedUser.role = user.role;
    clonedUser.idCompany = user.idCompany;
    clonedUser.firstName = user.firstName;
    clonedUser.lastName = user.lastName;
    clonedUser.phoneNumber = user.phoneNumber;
    clonedUser.adress = user.adress;

    return clonedUser;
  }
}

export class CatalogStr {
}
