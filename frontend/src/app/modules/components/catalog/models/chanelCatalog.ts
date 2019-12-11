export class ChanelCatalog {
  id: number;
  chanelName: string;
  owner: string;
  price: string;
  smallDiscription: string;
  category: string;
  companiesByOwner: string;

  static cloneBase(catalog: ChanelCatalog): ChanelCatalog {

    const clonedCatalog: ChanelCatalog = new ChanelCatalog();

    clonedCatalog.id = catalog.id;
    clonedCatalog.chanelName = catalog.chanelName;
    clonedCatalog.owner = catalog.owner;
    clonedCatalog.price = catalog.price;
    clonedCatalog.smallDiscription = catalog.smallDiscription;
    clonedCatalog.category = catalog.category;
    clonedCatalog.companiesByOwner = catalog.companiesByOwner;



    return clonedCatalog;
  }
}


export class CatalogStr {
}
