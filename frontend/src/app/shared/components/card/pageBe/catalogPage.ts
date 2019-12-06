import {Catalog} from "../../../../modules/components/catalog/models/catalog";

export class CatalogPage {

content: Catalog[];
totalPages: number;

  constructor(content,totalPages) {
    this.content = content;
    this.totalPages = totalPages;
  }



}
