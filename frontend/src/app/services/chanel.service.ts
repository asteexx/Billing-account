import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Catalog} from "../modules/components/catalog/models/catalog";
import {Observable} from "rxjs";
import {CatalogPage} from "../shared/components/card/pageBe/catalogPage";


@Injectable()
// Data service
export class ChanelService {

  constructor(private http: HttpClient) {
  }

  // Ajax request for Chanels data
  getAllChanels(page: number): Observable<CatalogPage> {

    return this.http.get<CatalogPage>('/api/chanels?page=' + page);
  }

  saveChanel(content: Catalog): Observable<CatalogPage> {

    return this.http.post<CatalogPage>('/api/chanels', content);
  }

  deleteChanel(chanelId: string): Observable<void> {
    return this.http.delete<void>('/api/chanels/' + chanelId);
  }

  getChanelById(id: string): Observable<Catalog> {
    return this.http.get<Catalog>('/api/chanels/' + id);
  }


}
