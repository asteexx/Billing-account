import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Catalog} from "../modules/components/catalog/models/catalog";
import {Observable} from "rxjs";


@Injectable()
// Data service
export class ChanelService {

  constructor(private http: HttpClient) {
  }

  // Ajax request for Chanels data
  getAllChanels(page: number): Observable<Catalog[]> {
    return this.http.get<Catalog[]>('/api/chanels?page=' + page);
  }

  saveChanel(catalog: Catalog): Observable<Catalog> {
    return this.http.post<Catalog>('/api/chanels', catalog);
  }

  deleteChanel(chanelId: string): Observable<void> {
    return this.http.delete<void>('/api/chanels/' + chanelId);
  }

  getChanelById(id: string): Observable<Catalog> {
    return this.http.get<Catalog>('/api/chanels/' + id);
  }


}
