
export class EWallet{
  id: number;
  moneyAmmount: number;
  subscriberId: number;


  static cloneBase(wallet: EWallet): EWallet {


    const clonedWallet: EWallet = new EWallet();
    clonedWallet.id = wallet.id;
    clonedWallet.moneyAmmount = wallet.moneyAmmount;
    clonedWallet.subscriberId = wallet.subscriberId;

    return clonedWallet;
  }


}
