import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Catalog} from "../modules/components/catalog/models/catalog";
import {User} from "../modules/components/registration-form/models/user";
import {LoginModel} from "../modules/components/common/nav-bar/models/login.model";
import {AuthToken} from "./security/user-service";

@Injectable()
// Data service
export class UserAddService {

  constructor(private http: HttpClient) {
  }

  // Ajax request for Users data


  saveUser(catalog: User): Observable<User> {
    return this.http.post<User>('/api/users', catalog);
  }



}
