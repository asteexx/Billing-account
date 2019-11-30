import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserModel} from "../../modules/components/common/nav-bar/models/user.model";
import {LoginModel} from "../../modules/components/common/nav-bar/models/login.model";


@Injectable()
export class UserService {

  constructor(private http: HttpClient) {
  }

  public generateToken(login: LoginModel): Observable<AuthToken> {
    return this.http.post<AuthToken>("/api/token/generate-token", login);
  }

  public getAuthorizedUser(): Observable<UserModel> {
    return this.http.get<UserModel>("/api/users/current");
  }

}

export interface AuthToken {
  readonly token: string;
}
