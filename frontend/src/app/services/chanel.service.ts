import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {ChanelCatalog} from "../modules/components/catalog/models/chanelCatalog";
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

  saveChanel(content: ChanelCatalog): Observable<CatalogPage> {

    return this.http.post<CatalogPage>('/api/chanels', content);
  }

  deleteChanel(chanelId: string): Observable<void> {
    return this.http.delete<void>('/api/chanels/' + chanelId);
  }

  getChanelById(id: string): Observable<ChanelCatalog> {
    return this.http.get<ChanelCatalog>('/api/chanels/' + id);
  }


}
