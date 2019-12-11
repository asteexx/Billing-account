import {ChanelCatalog} from "../../../../modules/components/catalog/models/chanelCatalog";

export class CatalogPage {

content: ChanelCatalog[];
totalPages: number;

  constructor(content,totalPages) {
    this.content = content;
    this.totalPages = totalPages;
  }



}
