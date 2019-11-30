
export class Catalog {
  id: string;
  chanelName: string;
  owner: string;
  price: string;
  smallDiscription: string;
  category: string;
  companiesByOwner: string;


  static cloneBase(catalog: Catalog): Catalog {
    const clonedCatalog: Catalog = new Catalog();
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
